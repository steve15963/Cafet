package xxx.petmanbe.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.entity.SearchCondition;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.board.service.BoardService;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.comment.entity.Comment;
import xxx.petmanbe.comment.service.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

	private final BoardService boardService;
	private final CommentService commentService;

	// 게시글 생성
	@PostMapping("/new")
	public ResponseEntity<Integer> postBoard(@RequestPart("dto") AddBoardRequestDto request){
		// 정보 추가
		boardService.postBoard(request);
		
		// 결과 전달
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 게시글 상세 보기
	@GetMapping("/{boardId}")
	public ResponseEntity<BoardResponseDto> getBoardDetail(@PathVariable Long boardId) {
		// 게시글 가져오기
		BoardResponseDto board = boardService.getBoardById(boardId);

		// 댓글 목록 가져오기
		List<CommentResponseDto> commentList = commentService.getCommentList(boardId);

		// dto에 등록
		board.setCommentList(commentList);

		// 결과 전달
		return new ResponseEntity<>(board, HttpStatus.OK);
	}

	// 게시글 목록 보기
	@GetMapping("/list")
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


	// 게시글 수정하기
	@PutMapping("/{boardId}")
	public ResponseEntity<Integer> putBoard(@PathVariable Long boardId, @RequestPart("dto") UpdateBoardRequestDto request){

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

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
