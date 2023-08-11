package xxx.petmanbe.board.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.AddCategoryRequestDto;
import xxx.petmanbe.board.dto.request.LikeRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.entity.Category;
import xxx.petmanbe.board.entity.LikeBoard;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.board.repository.CategoryRepository;
import xxx.petmanbe.board.repository.LikeBoardRepository;
import xxx.petmanbe.boardfile.dto.responseDto.BoardFileDto;
import xxx.petmanbe.boardfile.entity.BoardFile;
import xxx.petmanbe.boardfile.repository.BoardFileRepository;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.BoardErrorCode;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.exception.errorcode.TagErrorCode;
import xxx.petmanbe.exception.errorcode.UserErrorCode;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.entity.AttachBoard;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.repository.AttachBoardRepository;
import xxx.petmanbe.tag.repository.TagRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	private final AttachBoardRepository attachBoardRepository;
	private final TagRepository tagRepository;
	private final ShopRepository shopRepository;
	private final BoardFileRepository boardFileRepository;
	private final LikeBoardRepository likeBoardRepository;

	// 게시글 생성
	@Transactional
	@Override
	public Long postBoard(AddBoardRequestDto request){

		// 일단 게시글 제목과 내용으로 게시글 객체 생성
		Board board = request.toEntity();

		// 게시글 내용에서 <script> 태그 내용 제거
		// 정규 표현식 패턴 생성
		String patternString = "<script[^>]*>.*?</script>";
		Pattern pattern = Pattern.compile(patternString);

		// 문자열 내에서 패턴 검색
		Matcher matcher = pattern.matcher(request.getBoardContent());
		StringBuilder result = new StringBuilder();
		while (matcher.find()) {
			matcher.appendReplacement(result, "");
		}
		matcher.appendTail(result);

		// 제거된 문자열로 boardContent 최신화
		board.setBoardContent(String.valueOf(result));

		// 카테고리 찾고
		Category category = categoryRepository.findByCategoryName(request.getCategoryName())
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));

		// 정보 추가
		board.setCategory(category);

		// 유저 정보 찾고
		User user = userRepository.findById(request.getUserId())
			.orElseThrow(() -> new RestApiException(UserErrorCode.USER_NOT_FOUND));

		// 작성자 정보 저장
		board.setUser(user);

		// 게시글에 달린 가게 정보 가져오기
		Optional<Shop> shop = shopRepository.findByStatusFalseAndShopTitle(request.getShopTitle());
		Long defaultShopId = 1L; // null 일 때 사용할 값

		// 가게 정보 저장
		if (shop.isPresent()){
			board.setShop(shop.get());
		} else {
			// 해당 shop 이름으로 쿼리되는 값이 없으면 default 설정
			Optional<Shop> defaultShop = shopRepository.findById(defaultShopId);
			defaultShop.ifPresent(board::setShop);
		}

		// 해당 게시글에 태그 붙이기, 없으면 태그 생성
		for (TagListResponseDto response : request.getTagList()){
			// 만약 해당하는 이름의 태그가 없다면
			if (tagRepository.findByStatusFalseAndTagName(response.getTagName()).isEmpty()){
				// 태그 생성
				AddTagRequestDto tagRequest = AddTagRequestDto.builder()
					.tagName(response.getTagName())
					.build();
				tagRepository.save(tagRequest.toEntity());
			}
			// 있으면 해당하는 태그 가져오기
			Tag tag = tagRepository.findByStatusFalseAndTagName(response.getTagName())
				.orElseThrow(() -> new RestApiException(TagErrorCode.TAG_NOT_FOUND));

			AttachBoard attachBoard = AttachBoard.builder()
				.board(board)
				.tag(tag)
				.build();

			// 태그 부착 데이터 생성
			attachBoardRepository.save(attachBoard);
		}

		// 게시글 생성
		boardRepository.save(board);
		
		// id 전달
		return board.getBoardId();
	}

	// 카테고리 생성
	@Transactional
	@Override
	public Category postCategory(AddCategoryRequestDto request){
		return categoryRepository.save(request.toEntity());
	}

	// 게시글 상세 보기
	@Transactional
	@Override
	public BoardResponseDto getBoardById(Long boardId){

		// 반환할 게시글 정보
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));

		// 일단 조회수 증가
		board.updateViewCnt();

		// 게시글에 달린 댓글 목록 가져오기
		// 비즈니스 로직 상 게시글이 null일 수 없으므로 null 검사는 따로 하지 않음
		List<CommentResponseDto> commentList = board.getCommentList().stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());

		// 게시글에 달린 가게 정보 가져오기
		Optional<GetShopDto> shop = Optional.ofNullable(board.getShop()).map(GetShopDto::new);

		// 게시글에 달린 태그 목록을 가져오기 위해 가져오는 부착 기록
		List<AttachBoard> attachBoardList = attachBoardRepository.findByBoard_BoardId(boardId);

		// 태그 dto로 전환
		List<TagListResponseDto> taglist = attachBoardList.stream()
			.map(AttachBoard::getTag)
			.map(TagListResponseDto::new)
			.collect(Collectors.toList());

		// 사진 정보 가져오기
		List<BoardFile> boardFiles = boardFileRepository.findAllByBoard_BoardId(boardId);

		List<BoardFileDto> boardFileList = null;

		if(!Objects.isNull(boardFiles)){
			boardFileList=boardFiles.stream()
				.map(BoardFileDto::new)
				.collect(Collectors.toList());
		}

		// 게시글 정보 반환
		return BoardResponseDto.builder()
			.board(board)
			.commentList(commentList)
			.tagList(taglist)
			.shop(shop)
			.boardFileList(boardFileList)
			.build();
	}

	// 전체 게시글 보기
	@Override
	public List<BoardListResponseDto> getBoardList(){

		return boardRepository.findByStatusFalseOrderByBoardIdDesc().stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 글 제목으로 게시글 검색
	@Override
	public List<BoardListResponseDto> getBoardListByBoardTitle(String key){

		return boardRepository.findByStatusFalseAndBoardTitleContainingOrderByBoardIdDesc(key).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 글 내용으로 게시글 검색
	@Override
	public List<BoardListResponseDto> getBoardListByBoardContent(String key){

		return boardRepository.findByStatusFalseAndBoardContentContainingOrderByBoardIdDesc(key).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 태그로 게시글 검색
	@Override
	public List<BoardListResponseDto> getBoardListByTag(String tagName){

		// attachRespository를 이용해 해당 태그가 달려있는 목록을 가져오고
		// stream을 통해 자료형을 변환해 게시글 list 반환
		return attachBoardRepository.findByTag_TagName(tagName).stream()
			.map(AttachBoard::getBoard)
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 작성자로 게시글 검색
	@Override
	public List<BoardListResponseDto> getBoardListByNickname(String nickname){

		return boardRepository.findByStatusFalseAndUser_NicknameOrderByBoardIdDesc(nickname).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 카테고리별 게시글 검색
	@Override
	public List<BoardListResponseDto> getBoardListByCategoryId(Long categoryId){

		return boardRepository.findByStatusFalseAndCategory_CategoryIdOrderByBoardIdDesc(categoryId).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 가게별 게시글 보기
	@Override
	public List<BoardListResponseDto> getBoardListByShopId(Long shopId){

		return boardRepository.findByStatusFalseAndShop_ShopIdOrderByBoardIdDesc(shopId).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 좋아요 한 유저별 게시글 검색
	@Override
	public List<BoardListResponseDto> getLikeBoardListByUserId(Long userId){

		// 반환
		return likeBoardRepository.findByUser_UserId(userId).stream()
			.map(LikeBoard::getBoard)
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 게시글 수정: 제목, 내용, 카테고리, 태그
	@Transactional
	@Override
	public Board putBoard(Long boardId, UpdateBoardRequestDto request){

		// 게시글 정보 가져와서
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));

		// 해당 id를 가지는 게시글 정보 바꾸기
		board.updateBoard(boardId, request);

		// 카테고리 변경
		Category category = categoryRepository.findByCategoryName(request.getCategoryName())
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));
		board.setCategory(category);

		// 기존 태그 목록 확인
		for (AttachBoard curTag : attachBoardRepository.findByBoard_BoardId(boardId)) {

			// 수정된 태그들의 id 리스트
			List<Long> tagIdList = request.getTagList().stream()
				.map(TagListResponseDto::getTagId).collect(Collectors.toList());

			// 만약 해당 id가 없으면
			if (!tagIdList.contains(curTag.getTag().getTagId())){
				// 태그 리스트에서 제거
				attachBoardRepository.deleteByBoard_BoardIdAndTag_TagId(boardId, curTag.getTag().getTagId());
			}
		}

		// 새로 추가된 태그 확인
		for (TagListResponseDto updatedTag : request.getTagList()){

			// 현재 등록되어 있는 태그 id 목록
			List<Long> tagList = attachBoardRepository.findByBoard_BoardId(boardId).stream()
				.map(AttachBoard::getTag)
				.map(Tag::getTagId)
				.collect(Collectors.toList());

			// 업데이트 하려는 태그 id가 목록에 없으면 추가
			/*
				테스트 단계에서는 등록하려는 태그가 생성이 필요한 경우에 에러 발생할 수 있음
				그렇지만 비즈니스 로직 상 태그의 생성은 수정하기 버튼을 누르기(해당 메소드가 실행되는 시점) 전에,
				정확히 게시글 수정 창에서 태그 칸에 해당 태그의 이름을 입력하려고 onClick() 이벤트가 발생하는 순간에 일어나므로
				이 상태로 메소드를 유지함
			 */
			if (!tagList.contains(updatedTag.getTagId())){
				
				// 만약 태그가 없으면 만들기
				if (tagRepository.findByStatusFalseAndTagName(updatedTag.getTagName()).isEmpty()){
					Tag tag = Tag.builder()
						.tagName(updatedTag.getTagName())
						.build();
					tagRepository.save(tag);
				}
				
				// 부착정보 생성
				Tag tag = tagRepository.findByStatusFalseAndTagName(updatedTag.getTagName())
					.orElseThrow(() -> new RestApiException(TagErrorCode.TAG_NOT_FOUND));

				AttachBoard attachBoard = AttachBoard.builder()
					.tag(tag)
					.board(board)
					.build();

				attachBoardRepository.save(attachBoard);
			}
		}

		// 수정된 정보 반환
		return board;
	}

	// 게시글 좋아요 누르기
	@Transactional
	@Override
	public void postLike(LikeRequestDto request){

		// id로 게시글 찾고
		Board board = boardRepository.findById(request.getBoardId())
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));
		// 유저 찾고
		User user = userRepository.findById(request.getUserId())
			.orElseThrow(() -> new RestApiException(UserErrorCode.USER_NOT_FOUND));

		// 일단 좋아요가 눌려있는지 확인, 누른 적 없으면
		if (likeBoardRepository.findByBoard_BoardIdAndUser_UserId(request.getBoardId(), request.getUserId()).isEmpty()) {

			// 좋아요 데이터 만들어서 넣기
			LikeBoard newLike = LikeBoard.builder().build();

			newLike.setBoard(board);
			newLike.setUser(user);

			likeBoardRepository.save(newLike);

			// 게시글 좋아요+1
			board.plusLikeSum();
		} else {
			throw new RestApiException(BoardErrorCode.BOARD_ALREADY_LIKED);
		}
	}

	// 게시글 좋아요 취소
	@Transactional
	@Override
	public void deleteLike(LikeRequestDto request) {

		// id로 게시글 찾고
		Board board = boardRepository.findById(request.getBoardId())
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));

		// 일단 좋아요가 눌려있는지 확인, 누른 적 있으면
		likeBoardRepository.findByBoard_BoardIdAndUser_UserId(request.getBoardId(), request.getUserId())
			.ifPresentOrElse(
				// 해당 좋아요 정보가 있으면 삭제
				likeBoard -> {
					likeBoardRepository.deleteByBoard_BoardIdAndUser_UserId(request.getBoardId(), request.getUserId());
					board.minusLikeSum();
				},
				// 없으면 예외처리
				() -> {
					throw new RestApiException(BoardErrorCode.BOARD_ALREADY_LIKED);
				});
	}

	// 게시글 삭제 및 복구, update 메소드를 이용해 삭제 여부 값 변경
	@Transactional
	@Override
	public Board putBoardStatus(Long boardId){
		// id로 게시글 찾고
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));

		// 게시글 삭제여부 상태 변경
		board.changeDeleteStatus();

		// 수정된 정보 반환
		return board;
	}
}
