package org.enote.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.enote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@Api(value = "/", description = "Search for notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @ApiOperation(value = "Search notes by title", notes = "Provide a particular title")
    @RequestMapping(value = "/search_title", method = RequestMethod.GET)
    public String searchByTitle(@RequestParam String title, Model model) {
        return "index";
    }

    @ApiOperation(value = "Search notes by label", notes = "Provide a particular label")
    @RequestMapping(value = "/search_label", method = RequestMethod.GET)
    public String searchByLabel(@RequestParam String label, Model model) {
        return "index";
    }
}
