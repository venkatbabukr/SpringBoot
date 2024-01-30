package venkat.springboot.simple.jpademo.aller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venkat.springboot.simple.jpademo.aller.repos.CompaniesRepository;

@Service
public class CompaniesService {

	@Autowired
	private CompaniesRepository companiesRepo;
	
}
