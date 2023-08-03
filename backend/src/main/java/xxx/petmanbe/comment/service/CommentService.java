package xxx.petmanbe.comment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.repository.BoardRepository;
import xxx.petmanbe.comment.dto.request.AddCommentRequestDto;
import xxx.petmanbe.comment.dto.request.UpdateCommentRequestDto;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.comment.entity.Comment;
import xxx.petmanbe.comment.repository.CommentRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CommentService {
	private final BoardRepository boardRepository;
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;

	// 댓글 달기
	@Transactional
	public Comment postComment(Long boardId, Long userId, AddCommentRequestDto request){

		// dto를 comment로 변환시키고
		Comment comment	= request.toEntity();

		// 댓글 달릴 게시글 찾기
		Optional<Board> board = boardRepository.findById(boardId);

		// 등록할 게시글 정보 등록
		board.ifPresent(comment::setBoard);

		// 유저 정보 등록
		Optional<User> user = userRepository.findById(userId);
		user.ifPresent(comment::setUser);
		
		// 해당 게시글 카운트 증가
		board.ifPresent(Board::plusCommentSum);

		// 댓글 생성
		return commentRepository.save(comment);
	}

	// 댓글 목록 가져오기
	public List<CommentResponseDto> getCommentList(Long boardId){

		return commentRepository.findByStatusFalseAndBoard_BoardId(boardId).stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}

	// 사용자가 작성한 댓글 목록 가져오기
	public List<CommentResponseDto> getCommentListById(Long userId){

		return commentRepository.findByStatusFalseAndUser_UserId(userId).stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}

	// 댓글 수정하기
	@Transactional
	public Comment putComment(Long commentId, UpdateCommentRequestDto request){
		// 수정할 정보 가져오기
		Optional<Comment> comment = commentRepository.findById(commentId);

		// 해당 댓글 수정
		// 비즈니스 로직 상 게시글이 null일 수 없으므로 null 검사는 따로 하지 않음
		comment.get().updateComment(request);

		// 수정 정보 반환
		return comment.get();
	}

	// 댓글 삭제
	@Transactional
	public Comment putCommentStatus(Long commentId){

		// 수정할 정보 가져오기
		Optional<Comment> comment = commentRepository.findById(commentId);

		// 댓글 삭제/복구 상태 변경
		comment.ifPresent(Comment::updateCommentStatus);

		// 해당 댓글이 달려있는 게시글 정보
		// 비즈니스 로직 상 게시글이 null일 수 없으므로 null 검사는 따로 하지 않음
		Optional<Board> board = boardRepository.findById(comment.get().getBoard().getBoardId());

		// 댓글 수 변경
		board.ifPresent(Board::minusCommentSum);

		// 바뀐 댓글 정보 반환
		return comment.get();
	}
}
