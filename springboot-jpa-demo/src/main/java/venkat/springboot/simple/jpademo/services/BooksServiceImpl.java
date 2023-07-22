package venkat.springboot.simple.jpademo.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;
import venkat.springboot.simple.jpademo.exceptions.BookNotFoundException;
import venkat.springboot.simple.jpademo.exceptions.NotFoundResponseStatusException;
import venkat.springboot.simple.jpademo.repos.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepo;

    @PostConstruct
    private void initBooksData() {
        booksRepo.save(new Book("Book 1 from service", "Author 4", "ISBN4", BookCategory.ECONOMICS, 349.99));
        booksRepo.save(new Book("Book 2 from service", "Author 5", "ISBN5", BookCategory.POLITICS, 249.99));
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepo.findAll(Sort.by(Order.desc("title"), Order.asc("title")));
    }

    @Override
    public Book getById(Long id) {
        return booksRepo.findById(id).orElseThrow(() -> new BookNotFoundException());
    }

    @Override
    public Book getByIsbn(String isbn) {
        return booksRepo.queryByIsbn(isbn).orElseThrow(() -> new NotFoundResponseStatusException(String.format("No book found for isbn %s", isbn)));
    }

    @Override
    public List<Book> searchByTitle(String titleSearchStr, Direction sortDirection) {
        return booksRepo.findByTitleContaining(titleSearchStr, Sort.by(sortDirection, "title"));
    }

    @Override
    public List<Book> searchByCategory(BookCategory cat) {
        return booksRepo.findByCategory(cat).orElseThrow(() -> new RuntimeException());
    }

	@Override
	public List<Book> searchByPriceRange(Double startPrice) {
		// TODO Auto-generated method stub
		return booksRepo.findAllByPriceGreaterThan(startPrice);
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
