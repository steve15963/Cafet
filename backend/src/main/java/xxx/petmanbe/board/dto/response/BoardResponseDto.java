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
	private String boardTitle;
	private String boardContent;
	// user와 mapping 이후 resolve
	private String nickname;

	// shop과 mapping 이후 resolve
	private String shopTitle;
	private String categoryName;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
	// 좋아요 기능 생성시 resolve
	private int likeSum;
	private int commentSum;
	private int viewCnt;
	private boolean status;
	private List<CommentResponseDto> commentList;
	private List<TagListResponseDto> tagList;
	private Optional<GetShopDto> shop;
	private List<BoardFileDto> boardFileList;

	@Builder
	// entity to dto
	public BoardResponseDto(Board board, List<CommentResponseDto> commentList, List<TagListResponseDto> tagList, Optional<GetShopDto> shop, List<BoardFileDto> boardFileList){
		this.boardTitle = board.getBoardTitle();
		this.boardContent = board.getBoardContent();
		this.nickname = board.getUser().getNickname();
		this.categoryName = board.getCategory().getCategoryName();
		this.createdTime = board.getCreatedTime();
		this.updatedTime = board.getUpdatedTime();
		this.likeSum = board.getLikeSum();
		this.commentSum = board.getCommentSum();
		this.viewCnt = board.getViewCnt();
		this.status = board.isStatus();
		this.commentList = commentList;
		this.tagList = tagList;
		this.shop = shop;
		this.boardFileList = boardFileList;
	}
}
