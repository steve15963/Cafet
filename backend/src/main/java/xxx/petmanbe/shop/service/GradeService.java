package xxx.petmanbe.shop.service;

import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.GetShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopUserGradeDto;

public interface GradeService {

    public boolean postShopGrade(PostShopGradeDto postShopGradeDto);

    public GetShopUserGradeDto getShopGrade(long shopId, long userId);

    public boolean putShopGrade(PutShopGradeDto putShopGradeDto);

    public boolean deleteShopGrade(DeleteShopGradeDto deleteShopGradeDto);

}
