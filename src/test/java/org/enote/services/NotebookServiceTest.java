package org.enote.services;

import org.enote.TestPreConfig;
import org.enote.config.UserConfig;
import org.enote.domain.Notebook;
import org.enote.repos.NotebookRepo;
import org.enote.repos.UserRepo;
import org.enote.services.impl.NotebookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NotebookServiceImpl.class, UserConfig.class})
public class NotebookServiceTest extends TestPreConfig {

    @Autowired
    private NotebookServiceImpl notebookService;

    @Autowired
    private NotebookRepo notebookRepo;

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void notebookLifeCycleTest() {
        Notebook notebook = new Notebook();
    }
}
