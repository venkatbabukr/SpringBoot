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
        <td rowspan="2">
            Health <br />
            <br />
            <i>Parent endpoint</i> <br />
            http://localhost:8080/actuator/health <br />
            <br />
            <i>Name endpoints</i> <br />
            http://localhost:8080/actuator/health/ping <br />
            http://localhost:8080/actuator/health/diskSpace <br />
            http://localhost:8080/actuator/health/db <br />
            http://localhost:8080/actuator/health/rand
        </td>
        <td>management:<br />&emsp;health:<br />&emsp;&emsp;# db.enabled: true<br />&emsp;&emsp;# defaults.enabled: true<br />&emsp;&emsp;rand.enabled: true</td>
    </tr>
    <tr>
        <td>management:<br />&emsp;endpoint:<br />&emsp;&emsp;health.show-details: always</td>
    </tr>
    <tr>
        <td>Endpoints</td>
        <td>management:<br />&emsp;endpoints:<br />&emsp;&emsp;# web.base-path: /manage (Changes the context path from /actuator to /manage<br />&emsp;&emsp;web.exposure.include: * or gateway,health,info,metrics</td>
    </tr>
</table>

## Endpoints
1. Converter
    * [DirectionEnumConverter](src/main/java/venkat/springboot/simple/jpademo/common/endpoints/converters/DirectionEnumConverter.java): For convertion of String to Direction Enum

## Services
1. @PostConstruct
     * [Initialize database with data](src/main/java/venkat/springboot/simple/jpademo/common/services/LoadDatabase.java)

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

2. Entity-Relationships &amp; annotations
<table>
    <tr>
        <th>Relationship type</th>
        <th>Samples</th>
    </tr>
    <tr>
        <td colspan="2">
            <b><i><u>Associations</u></i></b>
        </td>
    </tr>
    <tr>
        <td>Unidirectional One-to-One mapping</td>
        <td><a href="src/main/java/venkat/springboot/simple/jpademo/aller/associations/entity/Company.java">Company</a> to HQ <a href="src/main/java/venkat/springboot/simple/jpademo/aller/associations/entity/Address.java">address</a></td>
    </tr>
    <tr>
        <td colspan="2">
            <b><i><u>Inheritance</u></i></b>
        </td>
    </tr>
    <tr>
        <td>Simple mapped super class</td>
        <td><a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Person.java">Person</a> - <a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Employee.java">Employee</a></td>
    </tr>
    <tr>
        <td>Single table Discriminator</td>
        <td><a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Product.java">Product</a> - <a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Pen.java">Pen</a>, <a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Scale.java">Scale</a></td>
    </tr>
    <tr>
        <td>Joined Discriminator</td>
        <td><a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Vehicle.java">Vehicle</a> - <a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Car.java">Car</a>, <a href="src/main/java/venkat/springboot/simple/jpademo/aller/inheritance/entity/Truck.java">Truck</a></td>
    </tr>
</table>

3. Audited entities
     * [Creation audits](src/main/java/venkat/springboot/simple/jpademo/common/entity/base/AuditedEntity.java)
     * [Modification audits](src/main/java/venkat/springboot/simple/jpademo/common/entity/base/AuditedModifiableEntity.java)
     * [Get the username for audits](src/main/java/venkat/springboot/simple/jpademo/common/entity/audit/AppAuditorAwareImpl.java)
4. [Sorting](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
     * [Direction](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
5. [Derived queries](src/main/java/venkat/springboot/simple/jpademo/book/repos/BooksRepository.java)

## Aspect oriented programming
1. [@LogExecutionTime](../common/src/main/java/venkat/common/logging/aop/LogExecutionTime.java)

## TODO
1. JPA @Subselect, @RestResource, @RepositoryRestResource etc…
     * See links: https://medium.com/@jonathan.turnock/exposing-subset-view-of-the-database-with-a-jpa-repository-over-rest-5b9d6e07344b
2. Spring security
     * CSRF: See the library com.allanditzel.spring-security-csrf-token-filter
3. Unit tests: Use Jupiter, Mockito, Hamcrest, AssertJ, Spring MockRestServiceServer etc...
     * See links: https://www.baeldung.com/spring-mock-rest-template
4. Incorporate other libraries like:
     * JSONLogic (https://jsonlogic.com/)

