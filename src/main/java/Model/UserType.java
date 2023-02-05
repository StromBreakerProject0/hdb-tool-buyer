package Model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "user_type")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class UserType extends Auditable<String>{

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid" , strategy = "uuid2")
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "isActive", nullable = false, columnDefinition = "Boolean default true")
    private Boolean isActive;
}
