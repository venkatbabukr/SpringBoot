package venkat.springboot.simple.jpademo.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;
import venkat.springboot.simple.jpademo.repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepo;

    @PostConstruct
    private void initBooksData() {
        System.out.println("Ïnside books service post construct");
    }

    @Override
    public List<Book> getAllBooks() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Book> getByCategory(BookCategory cat) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book searchByIsbn(String isbn) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Book saveNewBook(Book newBook) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean removeBook(Long bookId) {
        // TODO Auto-generated method stub
        return null;
    }

}
