package org.enote.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.enote.domain.util.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "attachment")
public class Attachment extends BaseEntity {

    @Basic
    @Column(name = "type")
    private String attr;
}
