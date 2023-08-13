package venkat.springboot.simple.jpademo.author.services;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import venkat.springboot.simple.jpademo.author.entity.projections.BooksCountByAuthor;
import venkat.springboot.simple.jpademo.book.dto.BookData;

public interface AuthorsService {

	List<String> getAllAuthors(Direction sortDir);

	List<BookData> searchByAuthor(String authorName);

	List<BooksCountByAuthor> getBooksCountByAuthor();

}
