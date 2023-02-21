package Soma.CLOVI.domain.Base;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
public class BaseEntity {

  @CreatedBy
  @Column(updatable = false)
  protected Long createBy;

  @LastModifiedBy
  protected Long lastModifiedBy;
  // 시간
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime createDate = LocalDateTime.now();

  @LastModifiedDate
  protected LocalDateTime lastModifiedDate;

  protected Boolean isDeleted = false;

}