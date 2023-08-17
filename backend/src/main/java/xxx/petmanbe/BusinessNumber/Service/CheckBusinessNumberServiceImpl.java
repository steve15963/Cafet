package xxx.petmanbe.BusinessNumber.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.BusinessNumber.DTO.Response.detail.ResponseBusinessNumberStatusDetailDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.nomal.ResponseBusinessNumberStatusDto;
import xxx.petmanbe.BusinessNumber.Repository.BusinessNumberRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class CheckBusinessNumberServiceImpl implements CheckBusinessNumberService {
	private final BusinessNumberRepository businessNumberRepository;

	@Override
	public boolean CheckBusinessNumber(String Number) {
		ResponseBusinessNumberStatusDto responseBusinessNumberStatusDto = businessNumberRepository.BusinessNumberSearch(
			Number);
		return responseBusinessNumberStatusDto.getData()[0].getB_no().equals(Number);
	}

	@Override
	public boolean CheckBusinessNumber(String Number, String date, String name) {
		ResponseBusinessNumberStatusDetailDto responseBusinessNumberStatusDetailDto = businessNumberRepository.BusinessNumberSearchDetail(
			Number, date, name);

		return responseBusinessNumberStatusDetailDto.getData()[0].getValid_msg() != null;
	}

}
