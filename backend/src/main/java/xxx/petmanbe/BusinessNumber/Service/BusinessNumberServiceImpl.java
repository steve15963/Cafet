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
public class BusinessNumberServiceImpl implements BusinessNumberService {
	private final BusinessNumberRepository businessNumberRepository;

	@Override
	public boolean CheckBusinessNumber(String num) {
		ResponseBusinessNumberStatusDto responseBusinessNumberStatusDto = businessNumberRepository.BusinessNumberSearch(
			num);
		if (responseBusinessNumberStatusDto == null)
			return false;
		log.info(responseBusinessNumberStatusDto.toString());

		/*
		  null == 조회실패
		  1 == 조회성공
		  n == n개 조회 성공
		 */
		return responseBusinessNumberStatusDto.getMatch_cnt() != null;
	}

	@Override
	public boolean CheckBusinessNumber(String num, String date, String name) {
		ResponseBusinessNumberStatusDetailDto responseBusinessNumberStatusDetailDto = businessNumberRepository.BusinessNumberSearchDetail(
			num, date, name);
		if (responseBusinessNumberStatusDetailDto == null)
			return false;
		log.info(responseBusinessNumberStatusDetailDto.toString());
		/*
		  null == 조회실패
		  1 == 조회성공
		  n == n개 조회 성공
		 */
		return responseBusinessNumberStatusDetailDto.getValid_cnt() != null;
	}

}
