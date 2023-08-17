package xxx.petmanbe.board.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.AddCategoryRequestDto;
import xxx.petmanbe.board.dto.request.LikeRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.service.BoardService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
@Tag(name = "게시판", description = "게시판 API Docs")
@CrossOrigin("*")
public class BoardController {

	private final BoardService boardService;

	@PostMapping(value="/new")
	@Operation(summary = "게시글 생성하기")
	@Transactional
	public ResponseEntity<String> postBoard(@RequestBody AddBoardRequestDto request) {
		// 게시글 생성
		boardService.postBoard(request);

		// 결과 전달
		return new ResponseEntity<>("success", HttpStatus.CREATED);
	}

	// 카테고리 생성
	@PostMapping("/category/new")
	@Operation(summary = "카테고리 만들기")
	public ResponseEntity<Integer> postCategory(@RequestBody AddCategoryRequestDto request){
		// 카테고리 생성
		boardService.postCategory(request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 게시글 좋아요
	@PostMapping("/like")
	@Operation(summary = "게시글 좋아요 누르기")
	public ResponseEntity<Integer> postLike(@RequestBody LikeRequestDto request){

		// 해당 게시글 좋아요 생성
		boardService.postLike(request);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 게시글 좋아요 삭제
	@DeleteMapping("/like")
	@Operation(summary = "게시글 좋아요 삭제")
	public ResponseEntity<Integer> deleteLike(@RequestBody LikeRequestDto request){

		// 해당 게시글 삭제
		boardService.deleteLike(request);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// 게시글 상세 보기
	@GetMapping("/{boardId}")
	@Operation(summary = "게시글 상세 보기")
	public ResponseEntity<BoardResponseDto> getBoardDetail(@PathVariable Long boardId) {
		// 게시글 가져오기
		BoardResponseDto board = boardService.getBoardById(boardId);

		// 결과 전달
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	// 게시글 전체 목록 보기
	@GetMapping("")
	@Operation(summary = "게시글 전체 목록 보기")
	public ResponseEntity<List<BoardListResponseDto>> getBoardList(){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardList();

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 사진이 있는 게시글 전체 목록 보기(메인용)
	@GetMapping("/main")
	@Operation(summary = "사진이 있는 게시글 전체 목록 보기(메인 페이지)")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListWithPics(){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListWithPics();

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 제목으로 검색
	@GetMapping("/title/{key}")
	@Operation(summary = "게시글 검색: 제목으로 검색")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByBoardTitle(@PathVariable String key){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByBoardTitle(key);

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 내용으로 검색
	@GetMapping("/content/{key}")
	@Operation(summary = "게시글 검색: 내용으로 검색")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByBoardContent(@PathVariable String key){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByBoardContent(key);

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 태그로 검색
	@GetMapping("/tag/{tagName}")
	@Operation(summary = "게시글 검색: 태그로 검색")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByTagName(@PathVariable String tagName){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByTag(tagName);

		// 결과 전달
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 검색 기능: 작성자로 검색
	@GetMapping("/nickname/{nickname}")
	@Operation(summary = "게시글 검색: 작성자로 검색")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByNickname(@PathVariable String nickname){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardlist = boardService.getBoardListByNickname(nickname);

		return new ResponseEntity<>(boardlist, HttpStatus.OK);
	}

	// 카테고리별 게시글 보기
	@GetMapping("/category/{categoryId}")
	@Operation(summary = "카테고리별 게시글 목록 보기")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByCategory(@PathVariable Long categoryId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByCategoryId(categoryId);

		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 가게별 게시글 보기
	@GetMapping("/shop/{shopId}")
	@Operation(summary = "가게별 게시글 보기")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByShopId(@PathVariable Long shopId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByShopId(shopId);

		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 유저가 쓴 게시글 목록 보기
	@GetMapping("/userId/{userId}")
	@Operation(summary = "해당 유저의 게시글 보기")
	public ResponseEntity<List<BoardListResponseDto>> getBoardListByUserId(@PathVariable Long userId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getBoardListByUserId(userId);

		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 유저가 좋아요한 게시글 목록 보기
	@GetMapping("/like/{userId}")
	@Operation(summary = "해당 유저가 좋아요한 게시글 보기")
	public ResponseEntity<List<BoardListResponseDto>> getLikeBoardListByUserId(@PathVariable Long userId){
		// 게시글 목록 가져오기
		List<BoardListResponseDto> boardList = boardService.getLikeBoardListByUserId(userId);

		// 반환
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}

	// 게시글 수정하기
	@PutMapping("")
	@Operation(summary = "게시글 수정하기")
	public ResponseEntity<Integer> putBoard(@RequestBody UpdateBoardRequestDto request){

		// 수정
		boardService.putBoard(request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 게시물 삭제 상태로 전환
	@DeleteMapping("/status/{boardId}")
	@Operation(summary = "게시글 삭제/복구하기")
	public ResponseEntity<Integer> putBoardStatus(@PathVariable Long boardId){
		// 삭제 상태로 전환
		boardService.putBoardStatus(boardId);

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
