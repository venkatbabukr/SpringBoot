package venkat.springboot.simple.jpademo.book.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import venkat.springboot.simple.jpademo.book.entity.Book;
import venkat.springboot.simple.jpademo.constants.BookCategory;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

	// Derived queries
    Optional<Book> queryByIsbn(String isbn);

    List<Book> findByTitleContaining(String titleSearchStr, Sort sort);

	Optional<List<Book>> findByCategory(BookCategory cat);

    // findBy, findAllBy are one and the same. Having this method name here just for reference
    // that we can use findAll as well...
    List<Book> findAllByPriceBetween(Double startPrice, Double endPrice);

}
