package xxx.petmanbe.Kiosk.desk.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostDeskDto;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PutTableDto;
import xxx.petmanbe.Kiosk.desk.dto.resquestDto.GetDeskDto;
import xxx.petmanbe.Kiosk.desk.entity.Desk;
import xxx.petmanbe.Kiosk.desk.repository.DeskRepository;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shop.repository.ShopRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeskServiceImpl implements DeskService{

    private final DeskRepository deskRepository;

    private final ShopRepository shopRepository;

    @Override
    public List<GetDeskDto> GetShopDesk(long shopId) {
        List<GetDeskDto> deskList = deskRepository.findAllByShop_ShopId(shopId).orElseThrow(()->new IllegalArgumentException()).stream()
                .map(GetDeskDto::new).collect(Collectors.toList());

        return deskList;
    }

    @Override
    public boolean postShop(PostDeskDto request) {

        Desk desk = deskRepository.findTopByShop_ShopId(request.getShopId());

        if(Objects.isNull(desk)){
            Shop shop = shopRepository.findById(request.getShopId()).orElseThrow(()->new IllegalArgumentException());

            Desk newDesk = Desk.builder()
                .shop(shop)
                .deskNum(1)
                .build();

            deskRepository.save(newDesk);

            return true;
        }

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
    public boolean deleteDesk(long shopId, long deskNum) {

        Desk desk = deskRepository.findByShopIdAndDeskNum(deskNum, shopId).orElseThrow(()->new IllegalArgumentException());

        deskRepository.delete(desk);

        return true;
    }

    @Override
    public boolean putDesk(long shopId, long deskNum, PutTableDto putTableDto) {

        Desk desk = deskRepository.findByShopIdAndDeskNum(deskNum, shopId).orElseThrow(()-> new IllegalArgumentException());

        List<GetDeskDto> getDeskList = GetShopDesk(shopId);

        for(GetDeskDto getDeskDto : getDeskList){
            if(Objects.equals(getDeskDto.getDeskNum(),deskNum)){

                return false;
            }
        }

        desk.setDeskNum(putTableDto.getTableNum());


        deskRepository.save(desk);

        return true;
    }

    //boolean true로 만들어주는 함수
}