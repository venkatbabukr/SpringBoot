package venkat.springboot.simple.jpademo.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import venkat.springboot.simple.jpademo.book.dto.BookData;
import venkat.springboot.simple.jpademo.book.entity.Book;
import venkat.springboot.simple.jpademo.book.repos.BooksRepository;
import venkat.springboot.simple.jpademo.book.services.BooksService;
import venkat.springboot.simple.jpademo.book.services.BooksServiceImpl;
import venkat.springboot.simple.jpademo.constants.BookCategory;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BooksServiceTest {

	@Autowired
	@InjectMocks
	private BooksService testBooksSvc = new BooksServiceImpl();

	@Mock
	private BooksRepository mockBooksRepo;

	@DisplayName("Test books service getAllBooks")
	@Test
	public void testGetAllBooks() {
		List<Book> mockAllBooks = Arrays.asList(
            new Book("Book 1 from service", "Author 4", "ISBN4", BookCategory.ECONOMICS, "199.99"),
            new Book("Book 2 from service", "Author 5", "ISBN5", BookCategory.POLITICS, "299.99"));

		when(mockBooksRepo.findAll(isA(Sort.class))).thenReturn(mockAllBooks);
		
		List<BookData> allBooks = testBooksSvc.getAllBooks();
		List<BookData> expectedAllBooks = Arrays.asList(
			new BookData(null, "Book 1 from service", "Author 4", "ISBN4", BookCategory.ECONOMICS, new BigDecimal("199.99")),
			new BookData(null, "Book 2 from service", "Author 5", "ISBN5", BookCategory.POLITICS, new BigDecimal("299.99")));
		assertEquals(expectedAllBooks, allBooks, "All books list mismatching!");
	}

	@DisplayName("Test books service searchByCategory")
	@Test
	public void testGetBooksByCategory() {
		when(mockBooksRepo.findByCategory(any())).thenReturn(null);
		assertThrows(RuntimeException.class, () -> testBooksSvc.searchByCategory(BookCategory.ECONOMICS));

		List<Book> mockEconomicBooks = Arrays.asList(
	            new Book("Book 1 from service", "Author 4", "ISBN4", BookCategory.ECONOMICS, "499.99"));

		when(mockBooksRepo.findByCategory(any())).thenReturn(
            Optional.of(mockEconomicBooks));
		List<Book> economicBooks = testBooksSvc.searchByCategory(BookCategory.ECONOMICS);
		List<Book> expectedEconomicBooks = new ArrayList<>(mockEconomicBooks);
		assertEquals(expectedEconomicBooks, economicBooks, "Economic books search list mismatch!");
	}

}
