package venkat.springboot.simple.jpademo.book.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import venkat.springboot.simple.jpademo.common.exceptions.NotFoundResponseStatusException;

/**
 * Sample exception having {@link ResponseStatus}. This is not scalable as we can't dynamically supply reason for book not found.
 * See {@link NotFoundResponseStatusException} for a more scalable exception handler using {@link ResponseStatusException} introduced from
 * Spring 5 onwards!
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Book not found!")
public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;


}
