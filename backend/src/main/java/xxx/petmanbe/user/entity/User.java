package xxx.petmanbe.user.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Column(length = 20, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Email
    @Column(nullable = false)
    @Size(min=2, max = 64)
    private String email;

    @Column(nullable = false)
    @Size(min=3, max = 25)
    private String password;

    @Column(nullable = false)
    @Size(min=13, max = 15)
    private String phoneNo;

    @Column(nullable = false)
    @Size(min=3, max = 10)
    private String nickname;

    @Column(nullable = false)
    @Size(min=2, max = 3)
    private String status;

    @Column(nullable = false)
    private int level;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdDate;

    @Column(nullable = false)
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="token_id")
    private Token token;

    @Builder
    public User(long userId, String email, String password, String phoneNo, String nickname, String status, int level,
        LocalDateTime createdDate, LocalDateTime updatedDate, Token token) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.phoneNo = phoneNo;
        this.nickname = nickname;
        this.status = status;
        this.level = level;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.token = token;
    }
}