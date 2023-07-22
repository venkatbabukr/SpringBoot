package venkat.springboot.simple.jpademo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
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

    @RequestMapping(path = "/isbn/{isbn}", method = RequestMethod.GET)
    public Book getByISBN(@PathVariable String isbn) {
        log.debug("Entering getByISBN(isbn={})", isbn);
        return booksSvc.getByIsbn(isbn);
    }

    @RequestMapping(path = "/search/title", method = RequestMethod.GET)
    public List<Book> searchByTitle(@RequestParam("q") String searchTitleStr, @RequestParam(name = "dir", defaultValue = "ASC") Direction sortDir) {
        log.debug("Entering searchByCategory(title={})", searchTitleStr);
        return booksSvc.searchByTitle(searchTitleStr, sortDir);
    }

    @RequestMapping(path = "/search/category", method = RequestMethod.GET)
    public List<Book> searchByCategory(@RequestParam("q") BookCategory cat) {
        log.debug("Entering searchByCategory(cat={})", cat);
        return booksSvc.searchByCategory(cat);
    }

    @RequestMapping(path = "/search/price", method = RequestMethod.GET)
    public List<Book> searchByPriceRange(@RequestParam("q") Double startPrice) {
        log.debug("Entering searchByPriceRange(startPrice={})", startPrice);
        return booksSvc.searchByPriceRange(startPrice);
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
