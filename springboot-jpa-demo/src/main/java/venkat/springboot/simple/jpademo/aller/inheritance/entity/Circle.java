package venkat.springboot.simple.jpademo.aller.inheritance.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CIRCLE")
public class Circle extends Shape {

	private Integer radius;

}
