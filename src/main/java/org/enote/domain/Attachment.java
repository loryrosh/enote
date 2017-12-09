package org.enote.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.enote.domain.util.AttachmentEnum;
import org.enote.domain.util.BaseEntity;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "attachment")
public class Attachment extends BaseEntity {

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "type")
    private AttachmentEnum type;
}
