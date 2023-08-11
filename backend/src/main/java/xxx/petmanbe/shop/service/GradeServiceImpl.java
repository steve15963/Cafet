package xxx.petmanbe.shop.service;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.CommonErrorCode;
import xxx.petmanbe.exception.errorcode.GradeErrorCode;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.exception.errorcode.UserErrorCode;
import xxx.petmanbe.shop.dto.requestDto.DeleteShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PostShopGradeDto;
import xxx.petmanbe.shop.dto.requestDto.PutShopGradeDto;
import xxx.petmanbe.shop.dto.responseDto.GetShopUserGradeDto;
import xxx.petmanbe.shop.entity.Grade;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.GradeRepository;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GradeServiceImpl implements GradeService{

    private final GradeRepository gradeRepository;

    private final ShopRepository shopRepository;

    private final UserRepository userRepository;

    // 유저의 가게 평점 주기
    @Transactional
    @Override
    public boolean postShopGrade(PostShopGradeDto postShopGradeDto) {

        Shop shop = shopRepository.findById(postShopGradeDto.getShopId())
            .orElseThrow(()->new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

        User user = userRepository.findById(postShopGradeDto.getUserId())
            .orElseThrow(()-> new RestApiException(UserErrorCode.USER_NOT_FOUND));

        Grade grade = Grade.builder()
                .value(postShopGradeDto.getValue())
                .shop(shop)
                .user(user)
                .build();

        gradeRepository.save(grade);

        shop.updateGrade(shop.getTotalScore()+ postShopGradeDto.getValue(), shop.getGradeCount()+1);

        shopRepository.save(shop);

        return true;
    }

    // 유저별 가게 평점 조회하기
    @Override
    public GetShopUserGradeDto getShopGrade(long shopId, long userId) {

		return gradeRepository.findByUserShopJpql(userId, shopId).stream()
            .map(GetShopUserGradeDto::new)
            .findFirst()
            .orElseThrow(()-> new RestApiException(CommonErrorCode.BAD_REQUEST));
    }

    // 유저별 가게 평점 수정하기
    @Override
    public boolean putShopGrade(PutShopGradeDto putShopGradeDto) {

        Grade grade = gradeRepository.findByUserShopJpql(putShopGradeDto.getUserId(), putShopGradeDto.getShopId())
            .orElseThrow(() -> new RestApiException(GradeErrorCode.GRADE_NOT_FOUND));

        Shop shop = shopRepository.findById(putShopGradeDto.getShopId())
            .orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

        shop.updateGrade(shop.getTotalScore()-grade.getValue()+putShopGradeDto.getValue(),shop.getGradeCount());
        grade.updateGrade(putShopGradeDto.getValue());

        gradeRepository.save(grade);
        shopRepository.save(shop);

        return true;
    }

    // 유저 별 가게 평점 삭제하기
    @Override
    public boolean deleteShopGrade(DeleteShopGradeDto deleteShopGradeDto) {

        Grade grade = gradeRepository.findByUserShopJpql(deleteShopGradeDto.getUserId(),deleteShopGradeDto.getUserId())
            .orElseThrow(() -> new RestApiException(GradeErrorCode.GRADE_NOT_FOUND));
        Shop shop = shopRepository.findById(deleteShopGradeDto.getShopId())
            .orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

        shop.updateGrade(shop.getTotalScore()-grade.getValue(),shop.getGradeCount()-1);

        gradeRepository.delete(grade);

        return true;
    }
}
