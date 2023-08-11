package xxx.petmanbe.BusinessNumber.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import xxx.petmanbe.BusinessNumber.DTO.Response.detail.ResponseBusinessNumberStatusDetailDto;
import xxx.petmanbe.BusinessNumber.DTO.Response.nomal.ResponseBusinessNumberStatusDto;
import xxx.petmanbe.BusinessNumber.Repository.BusinessNumberRepository;

@Slf4j
@Service
public class CheckBusinessNumberServiceImpl implements CheckBusinessNumberService {
	private BusinessNumberRepository businessNumberRepository;

	@Autowired
	public CheckBusinessNumberServiceImpl(BusinessNumberRepository businessNumberRepository) {
		this.businessNumberRepository = businessNumberRepository;
	}

	@Override
	public boolean CheckBusinessNumber(String Number) {
		ResponseBusinessNumberStatusDto responseBusinessNumberStatusDto = businessNumberRepository.BusinessNumberSearch(
			Number);
		if (responseBusinessNumberStatusDto.getData()[0].getB_no().equals(Number)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean CheckBusinessNumber(String Number, String date, String name) {
		ResponseBusinessNumberStatusDetailDto responseBusinessNumberStatusDetailDto = businessNumberRepository.BusinessNumberSearchDetail(
			Number, date, name);

		if (responseBusinessNumberStatusDetailDto.getData()[0].getValid_msg() == null)
			return false;
		return true;
	}

}
