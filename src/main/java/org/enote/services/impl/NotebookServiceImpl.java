package org.enote.services.impl;

import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.enote.repos.NotebookRepo;
import org.enote.services.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;

public class NotebookServiceImpl implements NotebookService {

    @Autowired
    private NotebookRepo notebookRepo;

    @Override
    public Note saveNote(Notebook notebook, Note note) {
        notebook.setNote(note);
        notebookRepo.save(notebook);

        return note;
    }
}
