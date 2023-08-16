package xxx.petmanbe.inquiry.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.inquiry.entity.InquiryCategory;

public interface InquiryCategoryRepository extends JpaRepository<InquiryCategory, Long> {
	Optional<InquiryCategory> findByInquiryCategoryName(String inquiryCategoryName);
}
