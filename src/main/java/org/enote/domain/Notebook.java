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
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "notebook")
public class Notebook extends BaseEntity {

    @Basic
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @OneToMany(mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Note> notes = new ArrayList<>();

    public Notebook(User user, String title, Date date) {
        this.user = user;
        this.title = title;
        this.date = date;
    }

    /**
     * Adds new note
     */
    public void addNote(Note note) {
        notes.add(note);
    }
}
