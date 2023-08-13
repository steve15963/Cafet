package xxx.petmanbe.Kiosk.desk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import xxx.petmanbe.shop.entity.Shop;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Desk {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "desk_id", nullable = false, updatable = false)
    private Long deskId;

    @Column
    private Long deskNum;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean fill;

    //shop이랑 연결
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id")
    private Shop shop;


}
