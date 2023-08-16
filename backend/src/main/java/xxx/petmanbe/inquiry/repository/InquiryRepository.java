package xxx.petmanbe.inquiry.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.inquiry.entity.Inquiry;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
	// 카테고리별 문의 리스트
	List<Inquiry> findByInquiryCategory_InquiryCategoryName(String inquiryCategoryName);
}
