package org.enote.controllers;

import org.enote.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @RequestMapping(value = "/")
    public String home(Model model) {
        model.addAttribute("data", "Hello!");
        return "home";
    }

    @RequestMapping(value = "/search_title", method = RequestMethod.GET)
    public String searchByTitle(@RequestParam String title, Model model) {
        return "home";
    }

    @RequestMapping(value = "/search_label", method = RequestMethod.GET)
    public String searchByLabel(@RequestParam String label, Model model) {
        return "home";
    }
}
