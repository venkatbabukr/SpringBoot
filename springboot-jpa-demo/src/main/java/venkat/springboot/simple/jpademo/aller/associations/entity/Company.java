package venkat.springboot.simple.jpademo.aller.associations.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;

	// This is a Uni-directional One-to-One mapping, as there is no reference of {@link Company} inside {@link Address}.
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "hq_addr_id")
	// @JoinColumn(name = "hq_addr_id", referencedColumnName = "id")
	private Address hqAddress;

	// This is also a uni-directional One-to-Many mapping!
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "company_addresses", joinColumns = @JoinColumn(name = "company_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	private List<Address> otherLocations;
	
}
