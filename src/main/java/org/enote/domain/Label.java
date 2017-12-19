package org.enote.domain;

import lombok.*;
import org.enote.domain.util.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "label")
public class Label extends BaseEntity {

    @Basic
    @Column(name = "color")
    @Getter(AccessLevel.NONE)
    private Integer color;

    @Basic
    @Column(name = "name")
    private String name;

    /**
     * Converts integer value into Color object
     *
     * @return - converted color
     */
    public Color getColor() {
        return new Color(color);
    }

    /**
     * Retrieves RGB int from Color object
     *
     * @param color - Color object
     */
    public void setColor(Color color) {
        this.color = color.getRGB();
    }
}
