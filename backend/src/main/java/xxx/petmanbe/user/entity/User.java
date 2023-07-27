package xxx.petmanbe.user.entity;

import lombok.*;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.userfile.entity.UserFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @Column(length = 20, nullable = false, name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Email
    @Column(nullable = false, unique = true)
    @Size(min=2, max = 64)
    private String email;

    @Column(nullable = false)
    @Size(min=3, max = 25)
    private String password;

    @Column(nullable = false, unique = true)
    @Size(min=11, max = 15)
    private String phoneNo;

    @Column(nullable = false, unique = true)
    @Size(min=3, max = 10)
    private String nickname;

    @Column(nullable = false)
    @Size(min=2, max = 3)
    private String status;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="level_id")
    private Level level;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="token_id")
    private Token token;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userfile_id")
    private UserFile userFile;

    public void updateUser( String phoneNo, String nickname) {
        this.phoneNo = phoneNo;
        this.nickname = nickname;
    }
}