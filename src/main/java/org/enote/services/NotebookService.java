package org.enote.services;

import org.enote.domain.Note;
import org.enote.domain.Notebook;

import java.util.List;

public interface NotebookService {

    /**
     * Saves new note
     *
     * @param notebook current notebook
     * @param note     new note
     * @return added note
     */
    Note saveNote(Notebook notebook, Note note);

    /**
     * Gets all user's notebooks
     *
     * @return list of notebooks
     */
    List<Notebook> getAllUserNotebooks();

    /**
     * Gets active notebook
     *
     * @return active notebook
     */

    Notebook getActiveNotebook() throws Exception;

    /**
     * Gets user default notebook
     *
     * @return default notebook
     */

    Notebook getDefaultNotebook() throws Exception;

    /**
     * Deletes default notebook
     */
    void deleteDefaultNotebook();
}
