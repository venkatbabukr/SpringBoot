package venkat.springboot.simple.jpademo.common.exceptions.handlers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

import venkat.springboot.simple.jpademo.common.exceptions.dto.ExceptionResponse;

@ControllerAdvice
public class AllEndPointsExceptionsHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleResponseStatusException(ResponseStatusException rse) {
		return ResponseEntity.status(rse.getStatus())
					.body(new ExceptionResponse(rse.getMessage()));
	}

//  Add this later when required...
//	@ExceptionHandler
//	public ResponseEntity<ExceptionResponse> handleIllegalArguments(IllegalArgumentException iae) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//					.body(null);
//	}

}
