package db.domain;

import db.domain.util.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "attachment")
public class Attachment extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private String type;
}
