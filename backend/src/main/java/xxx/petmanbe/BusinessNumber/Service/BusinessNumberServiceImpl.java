package xxx.petmanbe.BusinessNumber.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.BusinessNumber.DTO.Response.detail.ResponseBusinessNumberStatusDetailDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.nomal.ResponseBusinessNumberStatusDto;
import xxx.petmanbe.BusinessNumber.Repository.BusinessNumberRepository;

@Slf4j
@Service
public class BusinessNumberServiceImpl implements BusinessNumberService {
	private BusinessNumberRepository businessNumberRepository;

	@Autowired
	public BusinessNumberServiceImpl(BusinessNumberRepository businessNumberRepository) {
		this.businessNumberRepository = businessNumberRepository;
	}

	@Override
	public boolean CheckBsuinessNumber(String num) {
		ResponseBusinessNumberStatusDto responseBusinessNumberStatusDto = businessNumberRepository.BusinessNumberSearch(
			num);
		if (responseBusinessNumberStatusDto == null)
			return false;
		log.info(responseBusinessNumberStatusDto.toString());

		/**
		 * null == 조회실패
		 * 1 == 조회성공
		 * n == n개 조회 성공
		 */
		if (responseBusinessNumberStatusDto.getMatch_cnt() == null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean CheckBsuinessNumber(String num, String date, String name) {
		ResponseBusinessNumberStatusDetailDto responseBusinessNumberStatusDetailDto = businessNumberRepository.BusinessNumberSearchDetail(
			num, date, name);
		if (responseBusinessNumberStatusDetailDto == null)
			return false;
		log.info(responseBusinessNumberStatusDetailDto.toString());
		/**
		 * null == 조회실패
		 * 1 == 조회성공
		 * n == n개 조회 성공
		 */
		if (responseBusinessNumberStatusDetailDto.getValid_cnt() == null)
			return false;
		return true;
	}

}
