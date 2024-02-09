package venkat.springboot.simple.jpademo.aller.inheritance.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import venkat.springboot.simple.jpademo.aller.inheritance.enums.ShapeType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Shape {

	@Id
	@GeneratedValue
	private Long id;
	
	private String color;

	// NOTE: Not required here!
	//@Column(insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private ShapeType type;

}
