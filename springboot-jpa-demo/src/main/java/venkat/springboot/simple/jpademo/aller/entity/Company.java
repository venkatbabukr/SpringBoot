package venkat.springboot.simple.jpademo.aller.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "hq_addr_id", referencedColumnName = "id")
	private Address hqAddress;
	
	public Company(String nm, Address addr) {
		this.name = nm;
		this.hqAddress = addr;
	}
	
}
