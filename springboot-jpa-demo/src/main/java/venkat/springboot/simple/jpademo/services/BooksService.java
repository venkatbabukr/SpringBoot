package venkat.springboot.simple.jpademo.services;

import java.util.List;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;

public interface BooksService {

    List<Book> getAllBooks();
    
    List<Book> getByCategory(BookCategory cat);

    Book getById(Long id);

    Book searchByIsbn(String isbn);

    Book saveNewBook(Book newBook);
    
//    Book updateBook(Long id, Book updateBookDetails);

    Boolean removeBook(Long bookId);

}
