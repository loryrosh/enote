package org.enote.repos;

import org.enote.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepo extends JpaRepository<Note, Integer> {

}
