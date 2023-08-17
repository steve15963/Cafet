package xxx.petmanbe.comment.service;

import java.util.List;
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
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.BoardErrorCode;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.exception.errorcode.UserErrorCode;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final BoardRepository boardRepository;
	private final CommentRepository commentRepository;
	private final UserRepository userRepository;

	// 댓글 달기
	@Transactional
	@Override
	public void postComment(Long boardId, Long userId, AddCommentRequestDto request){

		// dto를 comment로 변환시키고
		Comment comment	= request.toEntity();

		// 댓글 달릴 게시글 찾기
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));

		// 등록할 게시글 정보 등록
		comment.setBoard(board);

		// 유저 정보 등록
		User user = userRepository.findById(userId)
			.orElseThrow(() -> new RestApiException(UserErrorCode.USER_NOT_FOUND));
		comment.setUser(user);
		
		// 해당 게시글 카운트 증가
		board.plusCommentSum();

		// 댓글 생성
		commentRepository.save(comment);
	}

	// 댓글 목록 가져오기
	@Override
	public List<CommentResponseDto> getCommentList(Long boardId){

		return commentRepository.findByStatusFalseAndBoard_BoardId(boardId).stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}

	// 사용자가 작성한 댓글 목록 가져오기
	@Override
	public List<CommentResponseDto> getCommentListById(Long userId){

		return commentRepository.findByStatusFalseAndUser_UserId(userId).stream()
			.map(CommentResponseDto::new)
			.collect(Collectors.toList());
	}

	// 댓글 수정하기
	@Transactional
	@Override
	public void putComment(UpdateCommentRequestDto request){
		// 수정할 정보 가져오기
		Comment comment = commentRepository.findById(request.getCommentId())
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));

		// 해당 댓글 수정
		comment.updateComment(request);

		// 수정 정보 반환
	}

	// 댓글 삭제
	@Transactional
	@Override
	public void putCommentStatus(Long commentId){

		// 수정할 정보 가져오기
		Comment comment = commentRepository.findById(commentId)
			.orElseThrow(() -> new RestApiException(CommonErrorCode.INVALID_PARAMETER));

		// 댓글 삭제/복구 상태 변경
		comment.updateCommentStatus();

		// 해당 댓글이 달려있는 게시글 정보
		Long boardId = comment.getBoard().getBoardId();
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new RestApiException(BoardErrorCode.BOARD_NOT_FOUND));

		// 댓글 수 변경
		if (comment.isStatus())
			board.minusCommentSum();
		else
			board.plusCommentSum();

		// 바뀐 댓글 정보 반환
	}
}
