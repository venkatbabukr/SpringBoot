package venkat.springboot.simple.jpademo.aller.entity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import venkat.springboot.simple.jpademo.aller.enums.Sex;

@Data
@MappedSuperclass
public class Person {
	
    @Id
    @GeneratedValue
	private Long id;

    private String firstName;
    
    private String lastName;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Sex sex;

}
