package xxx.petmanbe.visited.service;

import xxx.petmanbe.visited.dto.responseDto.DeleteVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.PostVisitedDateDto;

public interface VisitedService {
    Boolean getVisitedDate(long userId, long shopId);

    String postVisitedDate(PostVisitedDateDto postVisitedDateDto);

    String deleteVisitedDate(DeleteVisitedDateDto deleteVisitedDateDto);

}
