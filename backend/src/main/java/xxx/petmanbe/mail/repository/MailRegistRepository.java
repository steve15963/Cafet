package xxx.petmanbe.mail.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.mail.entity.RegistMail;

public interface MailRegistRepository extends JpaRepository<RegistMail,Long> {

	RegistMail findByMailTokenAndMail(String emailToken, String Email);

	Optional<RegistMail> findByMail(String email);

}
