package venkat.springboot.simple.jpademo.common.exceptions.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class ExceptionResponse {
	@NonNull
    private String errorMessage;
}
