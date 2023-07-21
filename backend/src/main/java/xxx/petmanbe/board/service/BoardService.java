package xxx.petmanbe.board.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.checkerframework.checker.units.qual.N;
import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.entity.SearchCondition;
import xxx.petmanbe.board.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	// id로 검색해서 찾기
	public BoardResponseDto getBoardById(Long boardId){

		Board board = boardRepository.findById(boardId)
			.orElseThrow();

		return new BoardResponseDto(board);
	}

	// 전체 게시글 보기
	public List<BoardListResponseDto> getBoardList(){

		return boardRepository.findByStatusFalse().stream()
			.map(BoardListResponseDto::new)
			.collect(Collectors.toList());
	}

	// 게시글 생성
	@Transactional
	public Board postBoard(AddBoardRequestDto request){
		return boardRepository.save(request.toEntity());
	}

	// 게시글 수정: 제목, 내용, 카테고리
	@Transactional
	public Board putBoard(Long boardId, UpdateBoardRequestDto request){

		// 해당 id를 가지고 있는지 확인, 없으면 에외 처리
		Board board = boardRepository.findById(boardId)
			.orElseThrow(() -> new IllegalArgumentException("not found"));

		// 해당 id를 가지는 게시글 정보 바꾸기
		board.updateBoard(boardId, request);

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
