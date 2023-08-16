package xxx.petmanbe.shopFile.entity;

import lombok.*;
import xxx.petmanbe.shop.entity.Shop;
import xxx.petmanbe.shopPet.entity.ShopPet;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopFile {


    @Id
    @Column(name="shopFile_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopFileId;


    @Column
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private Shop shop;

}
