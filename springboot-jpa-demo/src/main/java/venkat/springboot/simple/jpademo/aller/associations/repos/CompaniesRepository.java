package venkat.springboot.simple.jpademo.aller.associations.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import venkat.springboot.simple.jpademo.aller.associations.entity.Company;

public interface CompaniesRepository extends JpaRepository<Company, Long> {

}
