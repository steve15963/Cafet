package xxx.petmanbe.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Level {

    @Id
    @Column(name="level_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long levelId;

    @Column(name = "level_code", nullable = false, unique = true)
    private int levelCode;

}
