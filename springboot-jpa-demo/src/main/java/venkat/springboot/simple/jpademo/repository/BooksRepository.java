package venkat.springboot.simple.jpademo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.isbn = :isbn")
    Optional<Book> findByISBN(@Param("isbn") String isbn);
    
    @Query("select b from Book b where b.category = :cat")
    Optional<List<Book>> findByCategory(@Param("cat") BookCategory cat);

}
