package venkat.springboot.simple.jpademo.aller.associations.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Employee extends Person {

	@ManyToOne
	@JoinColumn(name = "company_id")
	private Company jobCompany;
	
}
