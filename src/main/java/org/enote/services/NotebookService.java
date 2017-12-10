package org.enote.services;

import org.enote.domain.Note;
import org.enote.domain.Notebook;

import java.util.List;

public interface NotebookService {

    /**
     * Saves new note
     *
     * @param note  new note
     * @return  added note
     */
    Note addNote(Note note) throws Exception;

    /**
     * Deletes note
     *
     * @param note  existing note
     * @return  deleted note
     */
    Note deleteNote(Note note) throws Exception;

    /**
     * Gets all user's notebooks
     *
     * @return list of notebooks
     */
    List<Notebook> getAllUserNotebooks();

    /**
     * Sets active notebook
     *
     * @param title notebook title
     */
    void setActiveNotebook(String title) throws Exception;

    /**
     * Gets active notebook
     *
     * @return active notebook
     */

    Notebook getActiveNotebook() throws Exception;

    /**
     * Deletes active notebook
     */
    void deleteActiveNotebook();
}
