package xxx.petmanbe.BusinessNumber.Repository;

import xxx.petmanbe.BusinessNumber.DTO.Response.detail.ResponseBusinessNumberStatusDetailDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.nomal.ResponseBusinessNumberStatusDto;

public interface BusinessNumberRepository {
	public ResponseBusinessNumberStatusDto BusinessNumberSearch(String BusinessNumber);

	public ResponseBusinessNumberStatusDetailDto BusinessNumberSearchDetail(
		String BusinessNumber,
		String StartDateTime,
		String RepresentativeName
	);
}
