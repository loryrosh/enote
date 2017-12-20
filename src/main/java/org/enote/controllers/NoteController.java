package org.enote.controllers;

import org.enote.domain.Note;
import org.enote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/search_title/{title}", method = RequestMethod.GET)
    public List<Note> searchByTitle(@PathVariable String title) {
        return null;
    }

    @RequestMapping(value = "/search_label/{label}", method = RequestMethod.GET)
    public List<Note> searchByLabel(@PathVariable String label) {
        return null;
    }
}
