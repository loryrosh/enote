package org.enote.services.impl;

import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.enote.domain.User;
import org.enote.repos.NotebookRepo;
import org.enote.services.NotebookService;
import org.enote.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.Date;
import java.util.List;

public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookRepo notebookRepo;

    @Autowired
    private UserService userService;

    private Notebook activeNotebook;
    private Notebook defaultNotebook;
    private List<Notebook> allNotebooks;

    @Override
    public Note saveNote(Notebook notebook, Note note) {
        notebook.setNote(note);
        notebookRepo.save(notebook);

        return note;
    }

    @Override
    public List<Notebook> getAllUserNotebooks() {
        if (allNotebooks == null) {
            // sorting notebooks from latest to earliest
            allNotebooks = notebookRepo.findAll(new Sort(Sort.Direction.DESC, "date"));
        }
        return allNotebooks;
    }

    @Override
    public Notebook getActiveNotebook() throws Exception {
        if (activeNotebook == null) {
            activeNotebook = getDefaultNotebook();
        }
        return activeNotebook;
    }

    @Override
    public Notebook getDefaultNotebook() throws Exception {
        if (defaultNotebook == null) {
            User user = userService.getActiveUser();
            defaultNotebook = notebookRepo.save(new Notebook(user, new Date()));
        }
        return defaultNotebook;
    }

    @Override
    public void deleteDefaultNotebook() {
        if (defaultNotebook != null) {
            notebookRepo.delete(defaultNotebook);
        }
    }
}
