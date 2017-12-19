package org.enote.repos;

import org.enote.TestPreConfig;
import org.enote.config.DataSourceConfigTest;
import org.enote.domain.Label;
import org.enote.domain.Note;
import org.enote.domain.Notebook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
public class NoteRepoTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);

    @Autowired
    private NoteRepo noteRepo;

    @Autowired
    private NotebookRepo notebookRepo;

    @Autowired
    private LabelRepo labelRepo;

    @Test
    public void getAllNotesByLabelsTest() {
        Optional<Notebook> notebook = notebookRepo.findById(1);

        if (notebook.isPresent()) {
            List<Label> labels = labelRepo.findAllById(Arrays.asList(1, 2));

            List<Note> notes = noteRepo.findAllByLabelsInAndNotebookOrderByDateDesc(labels, notebook.get());
            assertEquals(3, notes.size());
        } else {
            fail();
        }
    }

    @Test
    public void getAllNotesTest() {
        Optional<Notebook> notebook = notebookRepo.findById(1);

        if (notebook.isPresent()) {
            List<Note> notes = noteRepo.findAllByNotebookOrderByDateDesc(notebook.get());
            assertEquals(2, notes.size());
        } else {
            fail();
        }
    }
}
