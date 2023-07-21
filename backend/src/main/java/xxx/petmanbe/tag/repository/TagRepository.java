package xxx.petmanbe.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import xxx.petmanbe.tag.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
