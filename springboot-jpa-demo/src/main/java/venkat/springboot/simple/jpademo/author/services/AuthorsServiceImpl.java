package venkat.springboot.simple.jpademo.author.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import venkat.springboot.simple.jpademo.author.entity.projections.BooksCountByAuthor;
import venkat.springboot.simple.jpademo.author.repos.AuthorsRepository;
import venkat.springboot.simple.jpademo.book.dto.BookData;
import venkat.springboot.simple.jpademo.book.entity.Book;

@Slf4j
@Service
public class AuthorsServiceImpl implements AuthorsService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private AuthorsRepository authorsRepo;

	@Override
	public List<String> getAllAuthors(Direction sortDir) {
		return authorsRepo.getAllAuthors(Sort.by(sortDir, "author"));
	}

	@Override
	public List<BookData> searchByAuthor(String authorName) {
		log.debug("Entering searchByAuthor({})", authorName);
		List<Book> books = authorsRepo.findByAuthor(authorName);
		return mapper.map(books, new TypeToken<List<BookData>>() {}.getType());
	}

	@Override
	public List<BooksCountByAuthor> getBooksCountByAuthor() {
		log.debug("Entering getBooksCountByAuthor()");
		return authorsRepo.getBooksCountByAuthor();
	}

}
