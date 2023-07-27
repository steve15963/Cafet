package xxx.petmanbe.visited.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

        Visited visited = visitedRepository.findByUserShopJpql(getVisitedDateDto.getUserId(),
                getVisitedDateDto.getShopId()).orElseThrow(()-> new IllegalArgumentException());

        //방문상황이 없을 때 -> exception 처리해야 함
        // Exception(new NullPointerException()){
        // 	return false;
        // }

        return true;
    }

    @Override
    public String postVisitedDate(PostVisitedDateDto postVisitedDateDto) {

        Shop shop = shopRepository.findById(postVisitedDateDto.getShopId()).orElseThrow(()->new IllegalArgumentException());

        User user = userRepository.findById(postVisitedDateDto.getUserId()).orElseThrow(()-> new IllegalArgumentException());

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

        Visited visited = visitedRepository.findByUserShopJpql(deleteVisitedDateDto.getUserId(), deleteVisitedDateDto.getShopId()).orElseThrow(()-> new IllegalArgumentException());

        System.out.println(visited.getVisitedId());

        visitedRepository.delete(visited);


        return "success";
    }


}
