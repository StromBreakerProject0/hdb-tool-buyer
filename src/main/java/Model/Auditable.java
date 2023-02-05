package Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
public abstract class Auditable<U> {

    @CreatedBy
    @Column(name = "createdBy")
    protected U createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdOn")
    protected Date createdOn;

    @LastModifiedBy
    @Column(name = "modifiedBy")
    protected U modifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modifiedOn")
    protected U modifiedOn;
}
