package org.enote.services;

import org.enote.domain.Label;
import org.enote.domain.Note;
import org.enote.domain.Notebook;

import java.util.List;

public interface NoteService {

    /**
     * Saves the note
     *
     * @return saved note
     */
    Note saveNote(Note note);

    /**
     * Deletes the note
     *
     * @return deleted note
     */
    Note deleteNote(Note note);

    /**
     * Gets all notes sorted by date
     *
     * @param notebook  active notebook
     * @return  list of notes
     */
    List<Note> getAllNotes(Notebook notebook) throws Exception;

    /**
     * Gets all notes sorted by label and date
     *
     * @param labels  list of note labels
     * @param notebook  active notebook
     * @return  list of notes
     */
    List<Note> getAllNotesByLabels(List<Label> labels, Notebook notebook) throws Exception;
}
