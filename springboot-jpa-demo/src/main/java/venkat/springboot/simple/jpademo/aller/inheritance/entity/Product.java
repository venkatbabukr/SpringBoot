package venkat.springboot.simple.jpademo.aller.inheritance.entity;

import java.math.BigDecimal;

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
import venkat.springboot.simple.jpademo.aller.inheritance.enums.ProductType;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal price;

	// Adding @Column and insertable=false, updatable=false is very important here!
	// This column will be managed by Hibernate, so, very important!
	@Column(name = "product_type", insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private ProductType type;

}
