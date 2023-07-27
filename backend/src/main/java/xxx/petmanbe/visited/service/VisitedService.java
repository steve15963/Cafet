package xxx.petmanbe.visited.service;

import xxx.petmanbe.visited.dto.responseDto.DeleteVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.GetVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.PostVisitedDateDto;

public interface VisitedService {
    Boolean getVisitedDate(GetVisitedDateDto getVisitedDateDto);

    String postVisitedDate(PostVisitedDateDto postVisitedDateDto);

    String deleteVisitedDate(DeleteVisitedDateDto deleteVisitedDateDto);

}
