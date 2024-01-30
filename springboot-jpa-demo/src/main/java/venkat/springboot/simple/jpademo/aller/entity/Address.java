package venkat.springboot.simple.jpademo.aller.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String number;
	
	private String street;
	
	private String state;
	
	private String pinCode;

}
