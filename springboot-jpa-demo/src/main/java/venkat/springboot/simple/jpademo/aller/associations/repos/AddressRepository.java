package venkat.springboot.simple.jpademo.aller.associations.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import venkat.springboot.simple.jpademo.aller.associations.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
