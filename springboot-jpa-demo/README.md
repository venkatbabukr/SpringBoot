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
     * [Initialize database with data](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java)

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

2. Audited entities
     * [Creation audits](src/main/java/venkat/springboot/simple/jpademo/common/entity/base/AuditedEntity.java)
     * [Modification audits](src/main/java/venkat/springboot/simple/jpademo/common/entity/base/AuditedModifiableEntity.java)
     * [Get the username for audits](src/main/java/venkat/springboot/simple/jpademo/common/entity/audit/AppAuditorAwareImpl.java)
3. [Sorting](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
     * [Direction](src/main/java/venkat/springboot/simple/jpademo/book/services/BooksServiceImpl.java#searchByTitle): BooksServiceImpl.java#searchByTitle
4. [Derived queries](src/main/java/venkat/springboot/simple/jpademo/book/repos/BooksRepository.java)

## Aspect oriented programming
1. [@LogExecutionTime](../common/src/main/java/venkat/common/logging/aop/LogExecutionTime.java)
