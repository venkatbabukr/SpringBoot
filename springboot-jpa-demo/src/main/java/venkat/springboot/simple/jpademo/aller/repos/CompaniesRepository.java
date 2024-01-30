package venkat.springboot.simple.jpademo.aller.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import venkat.springboot.simple.jpademo.aller.entity.Company;

public interface CompaniesRepository extends JpaRepository<Company, Long> {

}
