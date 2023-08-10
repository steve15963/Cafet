package xxx.petmanbe.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.AddCategoryRequestDto;
import xxx.petmanbe.board.dto.request.LikeRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.service.BoardServiceImpl;
import xxx.petmanbe.boardfile.service.BoardFileService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@CrossOrigin("*")
public class BoardController {

	private final BoardServiceImpl boardService;

	private final BoardFileService boardFileService;

	// 게시글 생성
	// @PostMapping(value="/new", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// @Transactional
	// public ResponseEntity<String> postBoard(@RequestPart(value="dto") AddBoardRequestDto request, @RequestPart(value="files", required = false) List<MultipartFile> files) throws IOException {
	// 	// 게시글 생성
	// 	long boardId = boardService.postBoard(request);
	//
	// 	if(!Objects.isNull(files)){
	// 		if(boardFileService.keepFile(files, boardId)){
	// 			return new ResponseEntity<>("Success pictures in!",HttpStatus.OK);
	// 		}
	// 	}
	//
	// 	// 결과 전달
	// 	return new ResponseEntity<>("pictures not in",HttpStatus.CREATED);
	// }

	@PostMapping(value="/new")
	@Transactional
	public ResponseEntity<String> postBoard(@RequestBody AddBoardRequestDto request) throws IOException {
		// 게시글 생성
		long boardId = boardService.postBoard(request);

		// if(!Objects.isNull(files)){
		// 	if(boardFileService.keepFile(files, boardId)){
		// 		return new ResponseEntity<>("Success pictures in!",HttpStatus.OK);
		// 	}
		// }

		// 결과 전달
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}

	// 카테고리 생성
	@PostMapping("/category/new")
	public ResponseEntity<Integer> postCategory(@RequestBody AddCategoryRequestDto request){
		// 카테고리 생성
		boardService.postCategory(request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 게시글 좋아요
	@PostMapping("/like")
	public ResponseEntity<Integer> postLike(@RequestBody LikeRequestDto request){

		System.out.println(request.getBoardId());

		// 해당 게시글 좋아요 생성
		boardService.postLike(request);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 게시글 좋아요 삭제
	@DeleteMapping("/like")
	public ResponseEntity<Integer> deleteLike(@RequestBody LikeRequestDto request){

		// 해당 게시글 삭제
		boardService.deleteLike(request);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// 게시글 상세 보기
	@GetMapping("/{boardId}")
	public ResponseEntity<BoardResponseDto> getBoardDetail(@PathVariable Long boardId) {
		// 게시글 가져오기
		BoardResponseDto board = boardService.getBoardById(boardId);

		// 결과 전달
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	// 게시글 목록 보기
	@GetMapping("")
	public ResponseEntity<List<BoardListResponseDto>> getBoardList(){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardList();

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 제목으로 검색
	@GetMapping("/title/{key}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByBoardTitle(@PathVariable String key){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByBoardTitle(key);

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 내용으로 검색
	@GetMapping("/content/{key}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByBoardContent(@PathVariable String key){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByBoardContent(key);

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 태그로 검색
	@GetMapping("/tag/{tagName}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByTagName(@PathVariable String tagName){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByTag(tagName);

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 작성자로 검색
	@GetMapping("/nickname/{nickname}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByNickname(@PathVariable String nickname){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardlist = boardService.getBoardListByNickname(nickname);

		return new ResponseEntity<>(boardlist, HttpStatus.OK);
	}

	// 카테고리별 게시글 보기
	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByCategory(@PathVariable Long categoryId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByCategoryId(categoryId);

		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 가게별 게시글 보기
	@GetMapping("/shop/{shopId}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByShopId(@PathVariable Long shopId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByShopId(shopId);

		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 유저가 쓴 게시글 목록 보기
	@GetMapping("/userId/{userId}")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByUserId(@PathVariable Long userId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByUserId(userId);

		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 유저가 좋아요한 게시글 목록 보기
	@GetMapping("/like/{userId}")
	public ResponseEntity<List<BoardListResponseDto>> getLikeBoardListByUserId(@PathVariable Long userId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getLikeBoardListByUserId(userId);

		// 반환
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 수정하기
	@PutMapping("/{boardId}")
	public ResponseEntity<Integer> putBoard(@PathVariable Long boardId, @RequestBody UpdateBoardRequestDto request){

		// 수정
		boardService.putBoard(boardId, request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 게시물 삭제 상태로 전환
	@PutMapping("/status/{boardId}")
	public ResponseEntity<Integer> putBoardStatus(@PathVariable Long boardId){
		// 삭제 상태로 전환
		boardService.putBoardStatus(boardId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
