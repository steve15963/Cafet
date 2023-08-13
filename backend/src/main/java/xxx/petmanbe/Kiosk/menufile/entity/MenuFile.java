package xxx.petmanbe.Kiosk.menufile.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import xxx.petmanbe.Kiosk.menu.entity.Menu;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuFile {


    @Id
    @Column(name="menuFile_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long menuFileId;

    @Column
    private String url;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="menu_id")
    private Menu menu;


}
