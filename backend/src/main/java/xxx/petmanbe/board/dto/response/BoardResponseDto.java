package xxx.petmanbe.board.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.board.entity.Board;
import xxx.petmanbe.boardfile.dto.responseDto.BoardFileDto;
import xxx.petmanbe.comment.dto.response.CommentResponseDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopDto;
import xxx.petmanbe.tag.dto.response.TagListResponseDto;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
	private Long boardId;
	private String boardTitle;
	private String boardContent;
	private Long userId;
	private String nickname;
	private String categoryName;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	private int likeSum;
	private int commentSum;
	private int viewCnt;
	private List<CommentResponseDto> commentList;
	private List<TagListResponseDto> tagList;
	private GetShopDto shop;
	private List<BoardFileDto> boardFileList;

	@Builder
	// entity to dto
	public BoardResponseDto(Board board, List<CommentResponseDto> commentList, List<TagListResponseDto> tagList, GetShopDto shop, List<BoardFileDto> boardFileList){
		this.boardId = board.getBoardId();
		this.boardTitle = board.getBoardTitle();
		this.boardContent = board.getBoardContent();
		this.userId = board.getUser().getUserId();
		this.nickname = board.getUser().getNickname();
		this.categoryName = board.getCategory().getCategoryName();
		this.createdTime = board.getCreatedTime();
		this.updatedTime = board.getUpdatedTime();
		this.likeSum = board.getLikeSum();
		this.commentSum = board.getCommentSum();
		this.viewCnt = board.getViewCnt();
		this.commentList = commentList;
		this.tagList = tagList;
		this.shop = shop;
		this.boardFileList = boardFileList;
	}
}
