package venkat.springboot.simple.jpademo.common.services;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import venkat.common.logging.aop.LogExecutionTime;
import venkat.springboot.simple.jpademo.aller.associations.entity.Address;
import venkat.springboot.simple.jpademo.aller.associations.entity.Company;
import venkat.springboot.simple.jpademo.aller.associations.repos.CompaniesRepository;
import venkat.springboot.simple.jpademo.book.entity.Book;
import venkat.springboot.simple.jpademo.book.enums.BookCategory;
import venkat.springboot.simple.jpademo.book.repos.BooksRepository;

@Slf4j
@Service
@ConditionalOnProperty("app.init.load-data")
public class LoadDatabase {

	@Autowired
	private BooksRepository booksRepo;
	
	@Autowired
	private CompaniesRepository companiesRepo;

	@PostConstruct
    @LogExecutionTime
	public void init() {
		log.info("Loading all initial data into DB");

		List<Book> allBooks = Arrays.asList(
				new Book("Book 1 from service", "Author 4", "ISBN4", BookCategory.ECONOMICS, "349.99"),
				new Book("Book 2 from service", "Author 5", "ISBN5", BookCategory.POLITICS, "249.99"));
        booksRepo.saveAll(allBooks);
		log.info("Loaded all books data!");

		
		List<Company> companies = Arrays.asList(
				Company.builder()
					.name("Test Company1")
					.hqAddress(Address.builder().number("10").street("Borivalli").city("Mumbai").state("Maharastra")
							.pinCode("670034").build())
					.otherLocations(Arrays.asList(
							Address.builder().number("25").street("Lodhi road").city("New Delhi").state("Delhi").pinCode("110342").build(),
							Address.builder().number("585").street("Netaji marg").city("Kolkata").state("West Bengal").pinCode("700025").build()))
					.build(),
					Company.builder()
					.name("Test Company2")
					.hqAddress(Address.builder().number("354").street("Akkipet").city("Bengaluru").state("Karnataka")
							.pinCode("560053").build())
					.build());
		companiesRepo.saveAll(companies);
		log.info("Loaded all companies data!");
	}

}
