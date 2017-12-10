package org.enote.services.impl;

import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.enote.domain.User;
import org.enote.repos.NotebookRepo;
import org.enote.services.NoteService;
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

    @Autowired
    private NoteService noteService;

    private Notebook activeNotebook;
    private List<Notebook> allNotebooks;

    @Override
    public Note addNote(Note note) throws Exception {
        note.setNotebook(activeNotebook);
        note = noteService.saveNote(note);

        activeNotebook.addNote(note);
        notebookRepo.save(activeNotebook);

        return note;
    }

    @Override
    public Note deleteNote(Note note) throws Exception {
        if (activeNotebook.getNotes().contains(note)) {
            activeNotebook.getNotes().remove(note);
            noteService.deleteNote(note);
        }
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
    public void setActiveNotebook(String title) throws Exception {
        activeNotebook = notebookRepo.findByTitle(title);
    }

    @Override
    public Notebook getActiveNotebook() throws Exception {
        if (activeNotebook == null) {
            activeNotebook = getDefaultNotebook();
        }
        return activeNotebook;
    }

    @Override
    public void deleteActiveNotebook() {
        if (activeNotebook != null) {
            for (Note note : activeNotebook.getNotes()) {
                noteService.deleteNote(note);
            }
            notebookRepo.delete(activeNotebook);
        }
    }

    /**
     * Creates default notebook for the active user
     *
     * @return created notebook
     * @throws Exception
     */
    private Notebook getDefaultNotebook() throws Exception {
        User user = userService.getActiveUser();
        return notebookRepo.save(new Notebook(user, "Default", new Date()));
    }
}
