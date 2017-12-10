package org.enote.repos;

import org.enote.TestPreConfig;
import org.enote.domain.Notebook;
import org.enote.domain.User;
import org.enote.services.UserServiceTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {NotebookRepo.class, UserRepo.class})
public class NotebookServiceTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private NotebookRepo notebookRepo;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void notebookLifeCycleTest() {
        User user = userRepo.getOne(1);

        Notebook notebook = new Notebook(user, new Date());
        notebook = notebookRepo.save(notebook);
        logger.info("Notebook " + notebook.getId() + " was saved.");

        notebook.setUser(userRepo.getOne(2));
        notebook = notebookRepo.save(notebook);
        logger.info("Notebook was assigned to a new user: " + notebook.getUser().getName());
    }
}
