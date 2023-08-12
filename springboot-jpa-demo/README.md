# Concepts covered
Given below is list of concepts covered in the project so far.

## Configuration
1. [Model mapper configuration](src/main/java/venkat/springboot/simple/jpademo/config/AppConfig.java)

## JPA
1. [Application yaml](src/main/resources/application.yaml)
<table style="border: 1px solid black;">
    <tr>
        <th>Functionality</th>
        <th>Property config</th>
    </tr>
    <tr>
        <td>Automatic schema creation</td>
        <td>spring.jpa:<br />&emsp;hibernate.ddl-auto=create-drop</td>
    </tr>
    <tr>
        <td>Insert data through [data.sql](src/main/resources/data.sql)</td>
        <td>spring.jpa:<br />&emsp;hibernate.ddl-auto=create-drop</td>
    </tr>
    <tr>
        <td>Enable h2 console</td>
        <td>spring.h2:<br />&emsp;console.enabled=true</td>
    </tr>
</table>



     * Automatic schema creation: **spring.jpa:&emsp;hibernate.ddl-auto**=create-drop
     * Insert data through [data.sql](src/main/resources/data.sql): **spring.jpa:&emsp;defer-datasource-initialization**=true
     * Enable h2 console: **spring.h2:&emsp;console.enabled**=true
     * Hibernate logging
         * Log SQL queries: **logging.level:&emsp;org.hibernate.SQL=DEBUG**
         * Log parameters binding: **logging.level:&emsp;org.hibernate.type.descriptor.sql.BasicBinder=TRACE**

2. [Sorting](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
     * [Direction](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
3. [Derived queries](src/main/java/venkat/springboot/simple/jpademo/book/repos/BooksRepository.java)