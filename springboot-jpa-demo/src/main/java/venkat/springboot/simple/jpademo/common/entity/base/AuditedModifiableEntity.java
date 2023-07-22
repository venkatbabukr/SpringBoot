package venkat.springboot.simple.jpademo.common.entity.base;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AuditedModifiableEntity extends AuditedEntity {

	@LastModifiedBy
	private String modifiedBy;
	
	@LastModifiedDate
	private LocalDateTime modifiedAt;

}
