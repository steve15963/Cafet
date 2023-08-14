package xxx.petmanbe.Kiosk.menu.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuPriceSize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menuPriceSize_id", nullable = false, updatable = false)
    private int menuPriceSizeId;

    @Column
    private int menuPrice;

    @Column
    private String menuSize;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
