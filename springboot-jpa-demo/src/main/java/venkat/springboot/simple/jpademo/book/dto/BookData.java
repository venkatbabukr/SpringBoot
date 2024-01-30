package venkat.springboot.simple.jpademo.book.dto;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.validation.annotation.Validated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import venkat.springboot.simple.jpademo.book.enums.BookCategory;
import venkat.springboot.simple.jpademo.common.validation.ValidationGroups.OnCreate;
import venkat.springboot.simple.jpademo.common.validation.ValidationGroups.OnEdit;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class BookData {
	
	@Null(groups = OnCreate.class, message = "id should be null during create operation")
	@NotNull(groups = OnEdit.class, message = "ID required during edit operations")
    private Long id;
    
    @NotBlank(message = "Book Title can't be blank")
    private String title;
    @NotBlank(message = "Book Author can't be blank")
    private String author;
    @NotBlank(message = "Book ISBN required")
    private String isbn;
    @NotNull(message = "Book category required")
    private BookCategory category;
    @NotNull
    @DecimalMin(value = "0.99", message = "Price should be greater than or equal to 0.99")
    private BigDecimal price;

}
