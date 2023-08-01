package xxx.petmanbe.boardfile.dto.responseDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.boardfile.entity.BoardFile;

@Getter
@Setter
@NoArgsConstructor
public class BoardFileDto {

	private String boardUrl;

	public BoardFileDto(BoardFile boardFile){
		this.boardUrl = boardFile.getBoardUrl();
	}
}
