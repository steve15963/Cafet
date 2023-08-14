package xxx.petmanbe.Kiosk.desk.service;


import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostDeskDto;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PostFirstDeskDto;
import xxx.petmanbe.Kiosk.desk.dto.responseDto.PutTableDto;
import xxx.petmanbe.Kiosk.desk.dto.resquestDto.GetDeskDto;

import java.util.List;

public interface DeskService{

    public List<GetDeskDto> GetShopDesk(long shopId);

    public boolean postShop(PostDeskDto request);

    public boolean deleteDesk(long shopId, long deskNum);

    public boolean putDesk(long shopId, long deskNum, PutTableDto putTableDto);

    public boolean postFirstShop(PostFirstDeskDto request);


}
