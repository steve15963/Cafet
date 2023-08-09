package xxx.petmanbe.board.service;

import java.util.List;

import xxx.petmanbe.board.dto.request.AddBoardRequestDto;
import xxx.petmanbe.board.dto.request.AddCategoryRequestDto;
import xxx.petmanbe.board.dto.request.LikeRequestDto;
import xxx.petmanbe.board.dto.request.UpdateBoardRequestDto;
import xxx.petmanbe.board.dto.response.BoardListResponseDto;
import xxx.petmanbe.board.dto.response.BoardResponseDto;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.board.entity.Category;

public interface BoardService {

	// 게시글 생성
	Long postBoard(AddBoardRequestDto request);

	// 카테고리 생성
	Category postCategory(AddCategoryRequestDto request);

	// 게시글 상세보기
	BoardResponseDto getBoardById(Long boardId);

	// 전체 게시글 보기
	List<BoardListResponseDto> getBoardList();

	// 글 제목으로 게시글 검색
	List<BoardListResponseDto> getBoardListByBoardTitle(String key);

	// 글 내용으로 게시글 검색
	List<BoardListResponseDto> getBoardListByBoardContent(String key);

	// 태그이름으로 게시글 검색
	List<BoardListResponseDto> getBoardListByTag(String tagName);

	// 작성자 닉네임으로 게시글 검색
	List<BoardListResponseDto> getBoardListByNickname(String nickname);

	// 카테고리별 게시글 보기
	List<BoardListResponseDto> getBoardListByCategoryId(Long categoryId);

	// 가게별 게시글 보기
	List<BoardListResponseDto> getBoardListByShopId(Long shopId);

	// 유저별 게시글 보기
	List<BoardListResponseDto> getBoardListByUserId(Long userId);

	// 사용자별 좋아요한 게시글 보기
	List<BoardListResponseDto> getLikeBoardListByUserId(Long userId);

	// 게시글 수정
	Board putBoard(Long boardId, UpdateBoardRequestDto request);

	// 해당 게시글에 해당 유저 좋아요 추가
	void postLike(LikeRequestDto request);

	// 해당 게시글에 해당 유저 좋아요 삭제
	void deleteLike(LikeRequestDto request);

	// 게시글 삭제표시
	Board putBoardStatus(Long boardId);
}
