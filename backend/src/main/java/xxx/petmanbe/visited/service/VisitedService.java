package xxx.petmanbe.visited.service;

import java.time.LocalDateTime;

import xxx.petmanbe.visited.dto.reponseDto.DeleteVisitedDateDto;
import xxx.petmanbe.visited.dto.reponseDto.GetVisitedDateDto;
import xxx.petmanbe.visited.dto.reponseDto.PostVisitedDateDto;

public interface VisitedService {
	Boolean getVisitedDate(GetVisitedDateDto getVisitedDateDto);

	String postVisitedDate(PostVisitedDateDto postVisitedDateDto);

	String deleteVisitedDate(DeleteVisitedDateDto deleteVisitedDateDto);

}
