package xxx.petmanbe.shop.service;

import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.GetShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopUserGradeDto;

public interface GradeService {

    // 유저의 가게 평점 주기
    public boolean postShopGrade(PostShopGradeDto postShopGradeDto);

    // 유저별 가게 평점 조회하기
    public GetShopUserGradeDto getShopGrade(long shopId, long userId);

    // 유저별 가게 평점 수정하기
    public boolean putShopGrade(PutShopGradeDto putShopGradeDto);

    // 유저 별 가게 평점 삭제하기
    public boolean deleteShopGrade(DeleteShopGradeDto deleteShopGradeDto);

}
