package org.enote.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.enote.domain.util.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "note")
public class Note extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "notebook_id")
    private Notebook notebook;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @ManyToMany
    @JoinTable(name = "note_attachment",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "attachment_id")
    )
    private List<Attachment> attachments = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "note_label",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private List<Label> labels = new ArrayList<>();

    public Note(String title, String text, Date date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public Note(Notebook notebook, String title, String text, Date date) {
        this.title = title;
        this.notebook = notebook;
        this.text = text;
        this.date = date;
    }

    /**
     * Adds new attachment
     */
    public void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }

    /**
     * Adds new label
     */
    public void addLabel(Label label) {
        labels.add(label);
    }
}
