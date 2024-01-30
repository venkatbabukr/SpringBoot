package venkat.springboot.simple.jpademo.book.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import venkat.common.logging.aop.LogExecutionTime;
import venkat.springboot.simple.jpademo.book.dto.BookData;
import venkat.springboot.simple.jpademo.book.entity.Book;
import venkat.springboot.simple.jpademo.book.enums.BookCategory;
import venkat.springboot.simple.jpademo.book.exceptions.BookNotFoundException;
import venkat.springboot.simple.jpademo.book.repos.BooksRepository;
import venkat.springboot.simple.jpademo.common.exceptions.NotFoundResponseStatusException;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
    private BooksRepository booksRepo;

    @Override
    @LogExecutionTime
    public List<BookData> getAllBooks() {
        List<Book> allBooks = booksRepo.findAll(Sort.by(Order.desc("price"), Order.asc("title")));
        return mapper.map(allBooks, new TypeToken<List<BookData>>() {}.getType());
    }

    @Override
    public BookData getById(Long id) {
        return booksRepo
        		.findById(id)
        		.map(book -> mapper.map(book, BookData.class))
        		.orElseThrow(() -> new BookNotFoundException());
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
	public List<Book> searchByPriceRange(Double startPrice, Double endPrice) {
		// TODO Auto-generated method stub
		return booksRepo.findAllByPriceBetween(startPrice, endPrice);
	}

    @Override
    public BookData saveNewBook(BookData newBookData) {
    	// We don't need this as we have validation in place...
        // newBookData.setId(null);
        Book newBookEntity = mapper.map(newBookData, Book.class);

        newBookEntity = booksRepo.save(newBookEntity);
        return mapper.map(newBookEntity, BookData.class);
    }

    @Override
    public void removeBook(Long bookId) {
        booksRepo.deleteById(bookId);
    }

}
