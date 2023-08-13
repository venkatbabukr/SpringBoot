package venkat.springboot.simple.jpademo.author.entity.projections;

public interface BooksCountByAuthor {
	
	String getAuthor();
	int getBooksCount();

}
