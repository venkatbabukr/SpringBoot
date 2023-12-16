package venkat.springboot.simple.jpademo;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import venkat.springboot.simple.jpademo.book.entity.Book;
import venkat.springboot.simple.jpademo.book.repos.BooksRepository;

@Getter
enum CountOption {
	AUTHOR(Book::getAuthor), CATEGORY(Book::getCategory), PRICERANGE(b -> b.getPrice().precision() - b.getPrice().scale());
	
	private Function<Book, ?> classifier;
	private CountOption(Function<Book, ?> fn) {
		this.classifier = fn;
	}
}

@Slf4j
@SpringBootApplication
//@ConfigurationPropertiesScan
//@ComponentScan(basePackages = {"venkat.common", "venkat.springboot.simple.jpademo"})
//@EnableJpaRepositories
public class BooksCounterJob implements ApplicationRunner {

	@Autowired
	private BooksRepository booksRepo;

	private Map<Object, Long> getCountBy(CountOption opt) {
		return booksRepo.findAll().stream().collect(Collectors.groupingBy(opt.getClassifier(), Collectors.counting()));
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Raw: {}", Arrays.toString(args.getSourceArgs()));
		log.info("Non option arguments sent: {}", args.getNonOptionArgs());
		for (String option : args.getOptionNames()) {
			log.info("Option[{}]={}", option, args.getOptionValues(option));
		}

		Map<Object, Long> countByResult = Optional.ofNullable(args.getOptionValues("countby"))
     	                                      .filter(opts -> opts.size() > 0)
     	                                      .map(opts -> opts.get(0))
     	                                      .map(String::toUpperCase)
     	                                      .map(CountOption::valueOf)
                                              .map(this::getCountBy)
                                              .orElse(null);

		System.out.format("Count by result: %s%n", countByResult);
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(BooksCounterJob.class, args);
		ctx.close();
	}

}
