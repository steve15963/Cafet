package xxx.petmanbe.visited.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import xxx.petmanbe.exception.RestApiException;
import xxx.petmanbe.exception.errorcode.ShopErrorCode;
import xxx.petmanbe.exception.errorcode.UserErrorCode;
import xxx.petmanbe.exception.errorcode.VisitErrorCode;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;
import xxx.petmanbe.user.entity.User;
import xxx.petmanbe.user.repository.UserRepository;
import xxx.petmanbe.visited.dto.responseDto.DeleteVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.GetVisitedDateDto;
import xxx.petmanbe.visited.dto.responseDto.PostVisitedDateDto;
import xxx.petmanbe.visited.entity.Visited;
import xxx.petmanbe.visited.repository.VisitedRepository;

import static java.time.LocalDateTime.now;

@Service
@RequiredArgsConstructor
public class VisitedServiceImpl implements VisitedService{

    private final VisitedRepository visitedRepository;

    private final ShopRepository shopRepository;

    private final UserRepository userRepository;


    @Override
    public Boolean getVisitedDate(GetVisitedDateDto getVisitedDateDto) {

        Visited visited = visitedRepository.findByUserShopJpql(getVisitedDateDto.getUserId(), getVisitedDateDto.getShopId())
            .orElseThrow(()-> new RestApiException(VisitErrorCode.VISIT_NOT_FOUND));

        return true;
    }

    @Override
    public String postVisitedDate(PostVisitedDateDto postVisitedDateDto) {

        Shop shop = shopRepository.findById(postVisitedDateDto.getShopId())
            .orElseThrow(()-> new RestApiException(ShopErrorCode.SHOP_NOT_FOUND));

        User user = userRepository.findById(postVisitedDateDto.getUserId())
            .orElseThrow(()-> new RestApiException(UserErrorCode.USER_NOT_FOUND));

        Visited visit = Visited.builder()
                .shop(shop)
                .user(user)
                .visitedDate(now())
                .build();

        visitedRepository.save(visit);

        return "success";
    }

    @Override
    public String deleteVisitedDate(DeleteVisitedDateDto deleteVisitedDateDto) {

        Visited visited = visitedRepository.findByUserShopJpql(deleteVisitedDateDto.getUserId(), deleteVisitedDateDto.getShopId())
            .orElseThrow(()-> new RestApiException(VisitErrorCode.VISIT_NOT_FOUND));

        System.out.println(visited.getVisitedId());

        visitedRepository.delete(visited);


        return "success";
    }


}
