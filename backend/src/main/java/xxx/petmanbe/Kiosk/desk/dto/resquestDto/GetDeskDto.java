package xxx.petmanbe.Kiosk.desk.dto.resquestDto;

import lombok.*;
import xxx.petmanbe.Kiosk.desk.entity.Desk;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetDeskDto {

    @Column
    private long deskId;

    @Column
    private boolean fill;

    @Column
    private long deskNum;

    public GetDeskDto(Desk desk){
        this.deskId = desk.getDeskId();
        this.deskNum = desk.getDeskNum();
        this.fill = desk.isFill();
    }

}
