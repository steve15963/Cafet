package xxx.petmanbe.shop.service;

import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.GetShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;

public interface GradeService {

	public boolean postShopGrade(PostShopGradeDto postShopGradeDto);

	public boolean putShopGrade(PutShopGradeDto putShopGradeDto);

	public long getShopGrade(GetShopGradeDto getShopGradeDto);

	public boolean deleteShopGrade(DeleteShopGradeDto deleteShopGradeDto);
}
