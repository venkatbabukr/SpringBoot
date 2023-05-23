package venkat.springboot.simple.jpademo.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;
import venkat.springboot.simple.jpademo.repos.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepo;

    @PostConstruct
    private void initBooksData() {
        booksRepo.save(new Book("Book 1 from service", "Author 4", "ISBN4", BookCategory.ECONOMICS));
        booksRepo.save(new Book("Book 2 from service", "Author 5", "ISBN5", BookCategory.POLITICS));
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepo.findAll();
    }

    @Override
    public List<Book> searchByCategory(BookCategory cat) {
        return booksRepo.findByCategory(cat).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Book getById(Long id) {
        return booksRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return booksRepo.findByISBN(isbn).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Book saveNewBook(Book newBook) {
        newBook.setId(null);
        return booksRepo.save(newBook);
    }

    @Override
    public void removeBook(Long bookId) {
        booksRepo.deleteById(bookId);
    }

}
