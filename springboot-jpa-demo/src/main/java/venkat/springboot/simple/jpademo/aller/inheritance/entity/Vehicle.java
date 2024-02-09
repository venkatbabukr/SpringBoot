package venkat.springboot.simple.jpademo.aller.inheritance.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;
import venkat.springboot.simple.jpademo.aller.inheritance.enums.VehicleType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle {

	@Id
	private String vehicleNumber;
	
	private String engineNumber;
	
	private String chasisNumber;

	// NOTE: Not require here!
	//@Column(insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private VehicleType type;

}
