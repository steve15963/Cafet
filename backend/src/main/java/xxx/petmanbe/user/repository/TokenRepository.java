package xxx.petmanbe.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xxx.petmanbe.user.entity.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

	Token findByRefreshToken(String refreshToken);
}
