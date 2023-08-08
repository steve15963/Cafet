package xxx.petmanbe.comment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.comment.dto.request.AddCommentRequestDto;
import xxx.petmanbe.comment.dto.request.UpdateCommentRequestDto;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.comment.service.CommentServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
@CrossOrigin("*")
public class CommentController {
	private final CommentServiceImpl commentService;

	// 해당 게시글에 댓글 추가
	@PostMapping("/{boardId}/new/{userId}")
	public ResponseEntity<Integer> postComment(@PathVariable Long boardId, @PathVariable Long userId, @RequestBody AddCommentRequestDto request){

		// 생성하러 이동
		commentService.postComment(boardId, userId, request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 댓글 목록 가져오기
	@GetMapping("/board/{boardId}")
	public ResponseEntity<List<CommentResponseDto>> getCommentList(@PathVariable Long boardId){

		// 목록 가져오기
		List<CommentResponseDto> commentList = commentService.getCommentList(boardId);
		return new ResponseEntity<>(commentList, HttpStatus.OK);
	}

	// 작성자가 쓴 댓글 목록 가져오기
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<CommentResponseDto>> getCommentListByNickname(@PathVariable Long userId){

		// 목록 가져오기
		List<CommentResponseDto> commentList = commentService.getCommentListById(userId);
		return new ResponseEntity<>(commentList, HttpStatus.OK);
	}

	// 댓글 수정하기
	@PutMapping("/{commentId}")
	public ResponseEntity<Integer> putComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequestDto request){

		// 수정하기
		commentService.putComment(commentId, request);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// 댓글 삭제/복구 상태 전환
	@PutMapping("/status/{commentId}")
	public ResponseEntity<Integer> putCommentStatus(@PathVariable Long commentId){

		// 삭제상태 수정
		commentService.putCommentStatus(commentId);

		// 결과 전달
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
