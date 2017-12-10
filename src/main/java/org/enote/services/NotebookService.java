package org.enote.services;

import org.enote.domain.Note;
import org.enote.domain.Notebook;

import java.util.List;

public interface NotebookService {

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
     *
     *
     */
    void deleteDefaultNotebook();
}
