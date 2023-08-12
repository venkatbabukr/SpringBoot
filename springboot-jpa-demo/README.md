# Concepts covered
Given below is list of concepts covered in the project so far.

## Configuration
1. [Model mapper configuration](src/main/java/venkat/springboot/simple/jpademo/config/AppConfig.java)

## Actuator
1. [Application yaml](src/main/resources/application.yaml)

<table style="border: 1px solid black;">
    <tr>
        <th>Functionality</th>
        <th>Configuration</th>
    </tr>
    <tr>
        <td>Info</td>
        <td>management:<br />&emsp;info:<br />&emsp;&emsp;# java.enabled: true<br />&emsp;&emsp;env.enabled: true</td>
    </tr>
    <tr>
        <td>
            Health checks endpoints <br />
        </td>
        <td>management:<br />&emsp;health:<br />&emsp;&emsp;# db.enabled: true<br />&emsp;&emsp;defaults.enabled: true</td>
    </tr>
</table>


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
        <td>Insert data through <a href="src/main/resources/data.sql">data.sql</a></td>
        <td>spring.jpa:<br />&emsp;defer-datasource-initialization=true</td>
    </tr>
    <tr>
        <td>Enable h2 console</td>
        <td>spring.h2:<br />&emsp;console.enabled=true</td>
    </tr>
    <tr>
        <td colspan="2">Hibernate logging</td>
    </tr>
    <tr>
        <td>Log SQL queries</td>
        <td>logging.level:<br />&emsp;org.hibernate.SQL=DEBUG</td>
    </tr>
    <tr>
        <td>Log SQL query parameter bindings</td>
        <td>logging.level:<br />&emsp;org.hibernate.type.descriptor.sql.BasicBinder=TRACE</td>
    </tr>
</table>

2. [Sorting](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
     * [Direction](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
3. [Derived queries](src/main/java/venkat/springboot/simple/jpademo/book/repos/BooksRepository.java)
