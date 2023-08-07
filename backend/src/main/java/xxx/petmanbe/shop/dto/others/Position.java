package xxx.petmanbe.shop.dto.others;

import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Position {

    @Column
    private double longitude;

    @Column
    private double latitude;

}
