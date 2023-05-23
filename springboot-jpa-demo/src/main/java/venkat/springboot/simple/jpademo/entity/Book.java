package venkat.springboot.simple.jpademo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import venkat.springboot.simple.jpademo.constants.BookCategory;

@Entity
@Table(name = "BOOK")
public class Book {

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

    public Book() { }

    public Book(String title, String author, String isbn, BookCategory cat) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.category = cat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

}
