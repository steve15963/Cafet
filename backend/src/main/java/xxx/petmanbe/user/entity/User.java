package xxx.petmanbe.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lombok.*;
import xxx.petmanbe.common.entity.BaseTimeEntity;
import xxx.petmanbe.userfile.entity.UserFile;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity implements UserDetails
{

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="userfile_id")
    private UserFile userFile;


    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();
    ///

    public void updateUser( String phoneNo, String nickname) {
        this.phoneNo = phoneNo;
        this.nickname = nickname;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
            .map(SimpleGrantedAuthority::new)
            .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword(){return this.password;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}