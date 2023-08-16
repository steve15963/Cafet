package xxx.petmanbe.comment.service;

import java.util.List;

import xxx.petmanbe.comment.dto.request.AddCommentRequestDto;
import xxx.petmanbe.comment.dto.request.UpdateCommentRequestDto;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.comment.entity.Comment;

public interface CommentService {

	// 댓글 달기
	Comment postComment(Long boardId, Long userId, AddCommentRequestDto request);

	// 해당 게시글에 달린 댓글 목록 보기
	List<CommentResponseDto> getCommentList(Long boardId);

	// 해당 유저가 단 댓글 목록 보기
	List<CommentResponseDto> getCommentListById(Long userId);

	// 해당 댓글 수정하기
	Comment putComment(UpdateCommentRequestDto request);

	// 댓글 삭제(soft-delete)
	Comment putCommentStatus(Long commentId);
}
