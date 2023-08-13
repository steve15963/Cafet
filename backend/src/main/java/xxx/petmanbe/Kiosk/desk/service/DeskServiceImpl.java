package xxx.petmanbe.Kiosk.desk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostDeskDto;
import xxx.petmanbe.Kiosk.desk.dto.resquestDto.GetDeskDto;
import xxx.petmanbe.Kiosk.desk.entity.Desk;
import xxx.petmanbe.Kiosk.desk.repository.DeskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeskServiceImpl implements DeskService{

    private final DeskRepository deskRepository;


    @Override
    public List<GetDeskDto> GetShopDesk(long shopId) {
        List<GetDeskDto> deskList = deskRepository.findAllByShop_ShopId(shopId).orElseThrow(()->new IllegalArgumentException()).stream()
                .map(GetDeskDto::new).collect(Collectors.toList());

        return deskList;
    }

    @Override
    public boolean postShop(PostDeskDto request) {

        Desk desk = deskRepository.findTopByShop_ShopIdASC(request.getShopId()).orElseThrow(()->new IllegalArgumentException());

        long num = desk.getDeskNum();

        Desk newDesk = Desk.builder()
                .shop(desk.getShop())
                .deskNum(num+1)
                .build();

        deskRepository.save(newDesk);

        return true;
    }

    // 앞에 있는거 다 땡겨야 되나?
    @Override
    public boolean deleteDesk(long shopId, long tableNum) {

        Desk desk = deskRepository.findByShopIdAndDeskNum(tableNum, shopId).orElseThrow(()->new IllegalArgumentException());

        deskRepository.delete(desk);

        return true;
    }

    //boolean true로 만들어주는 함수
}
