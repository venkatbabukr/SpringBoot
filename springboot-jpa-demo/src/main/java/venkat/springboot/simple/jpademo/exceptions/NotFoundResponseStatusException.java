package venkat.springboot.simple.jpademo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NotFoundResponseStatusException extends ResponseStatusException {

	private static final long serialVersionUID = 1L;

	public NotFoundResponseStatusException(String reason) {
		super(HttpStatus.NOT_FOUND, reason);
	}

}
