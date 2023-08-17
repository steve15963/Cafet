package xxx.petmanbe.shop.service;

import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopUserGradeDto;

public interface GradeService {

    // 유저의 가게 평점 주기
    public void postShopGrade(PostShopGradeDto postShopGradeDto);

    // 유저별 가게 평점 조회하기
    public GetShopUserGradeDto getShopGrade(long shopId, long userId);

    // 유저별 가게 평점 수정하기
    public void putShopGrade(PutShopGradeDto putShopGradeDto);

    // 유저 별 가게 평점 삭제하기
    public void deleteShopGrade(DeleteShopGradeDto deleteShopGradeDto);

}
