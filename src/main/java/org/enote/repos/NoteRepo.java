package org.enote.repos;

import org.enote.domain.Label;
import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteRepo extends JpaRepository<Note, Integer> {

    List<Note> findAllByLabelsInAndNotebookOrderByDateDesc(List<Label> labels, Notebook notebook);

    List<Note> findAllByNotebookOrderByDateDesc(Notebook notebook);
}
