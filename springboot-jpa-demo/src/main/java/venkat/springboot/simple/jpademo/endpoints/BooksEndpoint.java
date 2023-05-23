package venkat.springboot.simple.jpademo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;
import venkat.springboot.simple.jpademo.services.BooksService;

@Slf4j
@RestController
@RequestMapping(path = "/books")
public class BooksEndpoint {

    @Autowired
    private BooksService booksSvc;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAll() {
        log.debug("Entering getAll");
        return booksSvc.getAllBooks();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable Long id) {
        log.debug("Entering getById(id={})", id);
        return booksSvc.getById(id);
    }

    @RequestMapping(path = "/search/isbn", method = RequestMethod.GET)
    public Book searchByISBN(@RequestParam String isbn) {
        log.debug("Entering searchByISBN(isbn={})", isbn);
        return booksSvc.searchByIsbn(isbn);
    }

    @RequestMapping(path = "/search/category", method = RequestMethod.GET)
    public List<Book> searchByCategory(@RequestParam BookCategory cat) {
        log.debug("Entering searchByCategory(cat={})", cat);
        return booksSvc.searchByCategory(cat);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book saveNewBook(Book newBook) {
        log.debug("Entering saveNewBook(newBook={})", newBook);
        return booksSvc.saveNewBook(newBook);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeById(Long id) {
        log.debug("Entering removeById(bookid={})", id);
        booksSvc.removeBook(id);
    }

}
