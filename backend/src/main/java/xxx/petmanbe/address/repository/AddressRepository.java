package xxx.petmanbe.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import xxx.petmanbe.address.entity.Address;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select distinct a.sidoName from Address a")
    List<String> findDistinctSidoName();

    @Query("select distinct a.gugunName from Address a where a.sidoName = :sidoName")
    List<String> findDistinctGugunName(@Param("sidoName") String sidoName);

}
