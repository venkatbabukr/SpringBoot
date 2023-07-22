package venkat.springboot.simple.jpademo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import venkat.springboot.simple.jpademo.constants.BookCategory;
import venkat.springboot.simple.jpademo.entity.audit.AuditedModifiableEntity;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "BOOK")
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

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    @Column(name = "PRICE")
    private Double price;

    public Book(String title, String author, String isbn, BookCategory cat, Double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = cat;
        this.price = price;
    }

}
