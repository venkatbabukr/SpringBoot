package venkat.springboot.simple.jpademo.author.repos;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import venkat.springboot.simple.jpademo.author.entity.projections.BooksCountByAuthor;
import venkat.springboot.simple.jpademo.book.entity.Book;

@Repository
public interface AuthorsRepository extends PagingAndSortingRepository<Book, Long> {

	@Query("SELECT DISTINCT b.author from Book b")
	List<String> getAllAuthors(Sort sortDir);

	List<Book> findByAuthor(String author);

	@Query("SELECT b.author as author, COUNT(b.id) AS booksCount FROM Book b GROUP BY b.author")
    List<BooksCountByAuthor> getBooksCountByAuthor();

}
