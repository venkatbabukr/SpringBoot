package venkat.springboot.simple.jpademo.entity.audit;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

/*
 * Check this link - has nice description of things...
 * https://progressivecoder.com/spring-boot-jpa-auditing-example-with-auditoraware-interface/
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditedEntity {

	@CreatedBy
	private String createdBy;
	
	@CreatedDate
	private LocalDateTime createdAt;

}
