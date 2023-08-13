package venkat.springboot.simple.jpademo.book.services;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import venkat.springboot.simple.jpademo.author.entity.projections.BooksCountByAuthor;
import venkat.springboot.simple.jpademo.book.dto.BookData;
import venkat.springboot.simple.jpademo.book.entity.Book;
import venkat.springboot.simple.jpademo.constants.BookCategory;

public interface BooksService {

    List<BookData> getAllBooks();

    BookData getById(Long id);

    Book getByIsbn(String isbn);

	List<Book> searchByTitle(String titleSearchStr, Direction sortDirection);

    List<Book> searchByCategory(BookCategory cat);

	List<Book> searchByPriceRange(Double startPrice, Double endPrice);
	
    BookData saveNewBook(BookData newBook);
    
//    Book updateBook(Long id, Book updateBookDetails);

    void removeBook(Long bookId);

}
