package xxx.petmanbe.KioskLogin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.KioskLogin.dto.responseDto.KioskLoginReturnDto;
import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.exception.errorcode.UserErrorCode;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.user.dto.requestDto.LoginDto;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class KioskServiceImpl implements KioskService{

    private final UserRepository userRepository;

    private final ShopRepository shopRepository;

    @Transactional
    @Override
    public KioskLoginReturnDto checkShop(LoginDto loginDto){

        User user = userRepository.findByEmail(loginDto.getEmail())
            .orElseThrow(()-> new RestApiException(UserErrorCode.USER_NOT_FOUND));

        int levelCode = user.getLevel().getLevelCode();

        if(levelCode <200){
            return null;
        }else if(levelCode >=300){

			return KioskLoginReturnDto.builder()
                    .levelCode(300)
                    .shopId((long)999999)
                    .build();

        }

        long shopId = shopRepository.findByStatusFalseAndUser(user)
            .orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND))
            .getShopId();

		return KioskLoginReturnDto.builder()
                .levelCode(levelCode)
                .shopId(shopId)
                .build();
    }



}
