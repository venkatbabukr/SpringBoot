package venkat.springboot.simple.jpademo.aller.inheritance.entity;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("TRUCK")
public class Truck extends Vehicle {

	private BigDecimal loadCapacity;

}
