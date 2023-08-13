package venkat.springboot.simple.jpademo.author.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import venkat.springboot.simple.jpademo.author.entity.projections.BooksCountByAuthor;
import venkat.springboot.simple.jpademo.author.services.AuthorsService;
import venkat.springboot.simple.jpademo.book.dto.BookData;

@Slf4j
@RestController
@RequestMapping(path = "/authors")
public class AuthorsEndpoint {

	@Autowired
	private AuthorsService authorsSvc;

	@GetMapping
	public List<String> getAllAuthors(@RequestParam(name = "dir", defaultValue = "ASC") Direction sortDir) {
		return authorsSvc.getAllAuthors(sortDir);
	}

	@GetMapping(path = "/search")
    public List<BookData> searchByAuthor(@RequestParam(name = "q", required = true) String authorName) {
		log.debug("Entering searchByAuthor({})", authorName);
		return authorsSvc.searchByAuthor(authorName);
	}

	@GetMapping("/all/books-count")
	public List<BooksCountByAuthor> getBooksCountByAuthor() {
		return authorsSvc.getBooksCountByAuthor();
	}
	
}
