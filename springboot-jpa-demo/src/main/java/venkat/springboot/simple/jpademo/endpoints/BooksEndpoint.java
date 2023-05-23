package venkat.springboot.simple.jpademo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.Book;
import venkat.springboot.simple.jpademo.services.BooksService;

@RestController
@RequestMapping(path = "/books")
public class BooksEndpoint {

    @Autowired
    private BooksService booksSvc;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> getAll() {
        return booksSvc.getAllBooks();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Book getById(@PathVariable Long id) {
        return booksSvc.getById(id);
    }

    @RequestMapping(path = "/search/isbn", method = RequestMethod.GET)
    public Book searchByISBN(@RequestParam String isbn) {
        return booksSvc.searchByIsbn(isbn);
    }

    @RequestMapping(path = "/search/category", method = RequestMethod.GET)
    public List<Book> searchByCategory(@RequestParam BookCategory cat) {
        return booksSvc.searchByCategory(cat);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book saveNewBook(Book newBook) {
        return booksSvc.saveNewBook(newBook);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void removeById(Long id) {
        booksSvc.removeBook(id);
    }

}
