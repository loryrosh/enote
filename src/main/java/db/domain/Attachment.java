package db.domain;

import db.domain.util.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "attachment")
public class Attachment extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
