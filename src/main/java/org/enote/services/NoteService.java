package org.enote.services;

import org.enote.domain.Note;

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
}
