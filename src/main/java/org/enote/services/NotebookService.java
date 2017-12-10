package org.enote.services;

import org.enote.domain.Note;
import org.enote.domain.Notebook;

public interface NotebookService {

    /**
     * Saves new note
     *
     * @param notebook current notebook
     * @param note     new note
     * @return added note
     */
    Note saveNote(Notebook notebook, Note note);
}
