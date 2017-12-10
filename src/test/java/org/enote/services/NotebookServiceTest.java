package org.enote.services;

import org.enote.TestPreConfig;
import org.enote.config.UserConfig;
import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.enote.services.impl.NoteServiceImpl;
import org.enote.services.impl.NotebookServiceImpl;
import org.enote.services.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NotebookServiceImpl.class,
        UserServiceImpl.class, UserConfig.class, NoteServiceImpl.class})
public class NotebookServiceTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(NotebookServiceTest.class);

    @Autowired
    private NotebookService notebookService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConfig userConfig;

    @Test
    public void lifeCycleTest() throws Exception {
        Notebook notebook = notebookService.getActiveNotebook();
        assertNotNull(notebook);

        Note note = notebookService.addNote(new Note("Default", "Another Text!", new Date()));
        assertNotNull(note);
        assertEquals(1, notebook.getNotes().size());

        notebookService.deleteNote(note);
        assertEquals(0, notebook.getNotes().size());

        notebookService.addNote(new Note("Default", "New Text!", new Date()));
        assertEquals(1, notebook.getNotes().size());

        notebookService.deleteActiveNotebook();
    }
}
