package org.enote.services.impl;

import org.enote.domain.Note;
import org.enote.repos.NoteRepo;
import org.enote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepo noteRepo;

    @Override
    public Note saveNote(Note note) {
        return noteRepo.save(note);
    }

    @Override
    public Note deleteNote(Note note) {
        if (noteRepo.existsById(note.getId())) {
            noteRepo.delete(note);
        }
        return note;
    }
}
