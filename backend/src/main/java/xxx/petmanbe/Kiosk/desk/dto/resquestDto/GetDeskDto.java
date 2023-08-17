package xxx.petmanbe.Kiosk.desk.dto.resquestDto;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import xxx.petmanbe.Kiosk.desk.entity.Desk;

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
