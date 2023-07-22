package venkat.springboot.simple.jpademo.services;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;

public interface BooksService {

    List<Book> getAllBooks();

    Book getById(Long id);

    Book getByIsbn(String isbn);

	List<Book> searchByTitle(String titleSearchStr, Direction sortDirection);

    List<Book> searchByCategory(BookCategory cat);

    List<Book> searchByPriceRange(Double startPrice);

    Book saveNewBook(Book newBook);
    
//    Book updateBook(Long id, Book updateBookDetails);

    void removeBook(Long bookId);

}
