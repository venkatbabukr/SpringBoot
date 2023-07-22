package venkat.springboot.simple.jpademo.common.endpoints.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class DirectionEnumConverter implements Converter<String, Direction> {

	@Override
	public Direction convert(String source) {
		try {
			return Direction.valueOf(source);
		} catch (IllegalArgumentException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid value %s given for direction!", source));
		}
	}

}
