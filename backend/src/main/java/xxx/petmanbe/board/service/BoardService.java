package xxx.petmanbe.board.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.AddCategoryRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.entity.Category;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.board.repository.CategoryRepository;
import xxx.petmanbe.boardfile.dto.responseDto.BoardFileDto;
import xxx.petmanbe.boardfile.entity.BoardFile;
import xxx.petmanbe.boardfile.repository.BoardFileRepository;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.comment.repository.CommentRepository;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.tag.dto.request.AddTagRequestDto;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;
import xxx.petmanbe.tag.entity.Attach;
import xxx.petmanbe.tag.entity.Tag;
import xxx.petmanbe.tag.repository.AttachRepository;
import xxx.petmanbe.tag.repository.TagRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	private final UserRepository userRepository;
	private final CommentRepository commentRepository;
	private final CategoryRepository categoryRepository;
	private final AttachRepository attachRepository;
	private final TagRepository tagRepository;
	private final ShopRepository shopRepository;
	private final BoardFileRepository boardFileRepository;

	// 게시글 생성
	@Transactional
	public Long postBoard(AddBoardRequestDto request){

		// 일단 게시글 제목과 내용으로 게시글 객체 생성
		Board board = boardRepository.save(request.toEntity());

		// 카테고리 찾고
		Optional<Category> category = categoryRepository.findByCategoryName(request.getCategoryName());

		// 정보 추가
		category.ifPresent(board::setCategory);

		// 유저 정보 찾고
		Optional<User> user = userRepository.findByNickname(request.getNickname());

		// 작성자 정보 저장
		user.ifPresent(board::setUser);

		// 게시글에 달린 가게 정보 가져오기
		Optional<Shop> shop = shopRepository.findByStatusFalseAndShopTitle(request.getShopTitle());

		// 가게 정보 저장
		shop.ifPresent(board::setShop);

		// 해당 게시글에 태그 붙이기(추후 프론트와 코드 병합 후 수정 예정)
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
				.orElseThrow(() -> new IllegalArgumentException("not found"));

			Attach attach = Attach.builder()
				.board(board)
				.tag(tag)
				.build();

			// 태그 부착 데이터 생성
			attachRepository.save(attach);
		}

		// 생성 정보 전달
		return board.getBoardId();
	}

	// 카테고리 생성
	public Category postCategory(AddCategoryRequestDto request){
		return categoryRepository.save(request.toEntity());
	}

	// 게시글 상세 보기
	@Transactional
	public BoardResponseDto getBoardById(Long boardId){

		// 반환할 게시글 정보
		Board board = boardRepository.findById(boardId)
			.orElseThrow();

		// 일단 조회수 증가
		board.updateViewCnt();

		// 게시글 작성자 정보 가져오기
		Optional<User> user = userRepository.findByNickname(board.getUser().getNickname());

		// 작성자 정보 저장
		user.ifPresent(board::setUser);

		// 게시글에 달린 댓글 목록 가져오기
		List<CommentResponseDto> commentList = commentRepository.findByStatusFalseAndBoard_BoardId(boardId).stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());

		// 댓글 수 데이터도 추가
		int commentSum = commentRepository.countByStatusFalseAndBoard_BoardId(boardId);
		board.setCommentSum(commentSum);

		// 게시글에 달린 태그 목록을 가져오기 위해 가져오는 부착 기록
		List<Attach> attachList = attachRepository.findByStatusFalseAndBoard_BoardId(boardId);

		// 태그 dto로 전환
		List<TagListResponseDto> taglist = attachList.stream()
			.map(Attach::getTag)
			.map(TagListResponseDto::new)
			.collect(Collectors.toList());

		// 가게 정보 가져오기(추후 mapping 방식이 바뀌면 수정)
		Optional<GetShopDto> shop = shopRepository.findByStatusFalseAndShopTitle(board.getShop().getShopTitle()).stream()
			.map(GetShopDto::new)
			.findFirst();

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
	public List<BoardListResponseDto> getBoardList(){

		return boardRepository.findByStatusFalse().stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 글 제목으로 게시글 검색
	public List<BoardListResponseDto> getBoardListByBoardTitle(String key){

		return boardRepository.findByStatusFalseAndBoardTitleContaining(key).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 글 내용으로 게시글 검색
	public List<BoardListResponseDto> getBoardListByBoardContent(String key){

		return boardRepository.findByStatusFalseAndBoardContentContaining(key).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 태그로 게시글 검색
	public List<BoardListResponseDto> getBoardListByTag(String tagName){

		// attachRespository를 이용해 해당 태그가 달려있는 목록을 가져오고
		// stream을 통해 자료형을 변환해 게시글 list 반환
		return attachRepository.findByStatusFalseAndTag_TagName(tagName).stream()
			.map(Attach::getBoard)
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 작성자로 게시글 검색
	public List<BoardListResponseDto> getBoardListByNickname(String nickname){

		return boardRepository.findByStatusFalseAndUser_Nickname(nickname).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 카테고리별 게시글 검색
	public List<BoardListResponseDto> getBoardListByCategoryId(Long categoryId){

		return boardRepository.findByStatusFalseAndCategory_CategoryId(categoryId).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 가게별 게시글 보기
	public List<BoardListResponseDto> getBoardListByShopId(Long shopId){

		return boardRepository.findByStatusFalseAndShop_ShopId(shopId).stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 게시글 수정: 제목, 내용, 카테고리, 태그
	@Transactional
	public Board putBoard(Long boardId, UpdateBoardRequestDto request){

		// 해당 id를 가지고 있는지 확인, 없으면 에외 처리
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("not found"));

		// 해당 id를 가지는 게시글 정보 바꾸기
		board.updateBoard(boardId, request);

		// 카테고리 변경
		board.updateCategory(categoryRepository.findByCategoryName(request.getCategoryName())
			.orElseThrow(() -> new IllegalArgumentException("not found")));

		// 기존 태그 목록 확인
		for (Attach curTag : attachRepository.findByStatusFalseAndBoard_BoardId(boardId)) {

			// 수정된 태그들의 id 리스트
			List<Long> tagIdList = request.getTagList().stream()
				.map(TagListResponseDto::getTagId).collect(Collectors.toList());

			// 만약 해당 id가 없으면
			if (!tagIdList.contains(curTag.getTag().getTagId())){
				// 태그 리스트에서 제거
				Attach attach = attachRepository.findByBoard_BoardIdAndTag_TagId(boardId, curTag.getTag().getTagId())
					.orElseThrow(() -> new IllegalArgumentException("not found"));

				// 삭제 형태로 표시
				attach.changeDeleteStatus();
			}
		}

		// 새로 추가된 태그 확인
		for (TagListResponseDto updatedTag : request.getTagList()){

			// 현재 등록되어 있는 태그 id 목록
			List<Long> tagList = attachRepository.findByStatusFalseAndBoard_BoardId(boardId).stream()
				.map(Attach::getTag)
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
				Attach attach = Attach.builder()
					.tag(tagRepository.findByStatusFalseAndTagName(updatedTag.getTagName())
						.orElseThrow(() -> new IllegalArgumentException("not found")))
					.board(board)
					.build();

				attachRepository.save(attach);
			}
		}


		// 수정된 정보 반환
		return board;
	}

	// 게시글 삭제 및 복구, update 메소드를 이용해 삭제 여부 값 변경
	@Transactional
	public Board putBoardStatus(Long boardId){
		// id로 게시글 찾고
		Board board = boardRepository.findById(boardId).
			orElseThrow(() -> new IllegalArgumentException("not found"));

		// 게시글 삭제여부 상태 변경
		board.changeDeleteStatus();

		// 수정된 정보 반환
		return board;
	}
}
