package org.enote.services.impl;

import org.enote.domain.Label;
import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.enote.repos.NoteRepo;
import org.enote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Override
    public List<Note> getAllNotes(Notebook notebook) throws Exception {
        return noteRepo.findAllByNotebookOrderByDateDesc(notebook);
    }

    @Override
    public List<Note> getAllNotesByLabels(List<Label> labels, Notebook notebook) throws Exception {
        return noteRepo.findAllByLabelsInAndNotebookOrderByDateDesc(labels, notebook);
    }
}
