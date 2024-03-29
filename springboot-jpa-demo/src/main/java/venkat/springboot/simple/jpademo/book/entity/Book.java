package venkat.springboot.simple.jpademo.book.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import venkat.springboot.simple.jpademo.book.enums.BookCategory;
import venkat.springboot.simple.jpademo.common.entity.base.AuditedModifiableEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BOOK",
	// Normally we don't create indexes in entity classes. We create and manage indexes
	// as part of database management scripts.
	indexes = {
			@Index(columnList = "author"),
			@Index(columnList = "isbn", unique = true),
			@Index(columnList = "category") })
@Audited
@NoArgsConstructor
public class Book extends AuditedModifiableEntity {

    @Id
    @GeneratedValue(generator = "sg1")
    @SequenceGenerator(name = "sg1", sequenceName = "booksSequence", initialValue = 4, allocationSize = 1)

    // @GeneratedValue(strategy = GenerationType.SEQUENCE)

//    @GenericGenerator(
//        name = "sg1",
//        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//        parameters = {
//            @Parameter(name = "sequence_name", value = "book_sequence"),
//            @Parameter(name = "initial_value", value = "4"),
//            @Parameter(name = "increment_size", value = "1") })
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "ISBN", unique = true)
    private String isbn;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    // See links like these for choosing BigDecimal type!
    // https://www.linkedin.com/pulse/why-we-should-use-bigdecimal-instead-double-java-financial-ismail/
    @Column(name = "PRICE")
    private BigDecimal price;

    public Book(String title, String author, String isbn, BookCategory cat, String price) {
    	this(title, author, isbn, cat, new BigDecimal(price));
    }

    public Book(String title, String author, String isbn, BookCategory cat, BigDecimal price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = cat;
        this.price = price;
    }

}
