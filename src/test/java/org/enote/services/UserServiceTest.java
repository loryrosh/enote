package org.enote.services;

import org.enote.TestPreConfig;
import org.enote.UserConfig;
import org.enote.domain.User;
import org.enote.repos.UserRepo;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {UserServiceImpl.class, UserConfig.class})
public class UserServiceTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private UserConfig userConfig;

    @Autowired
    private UserRepo userRepo;

    @Test
    public void userLifeCycleTest() {
        User user = new User("Will@mail.ru", "password", "Will", "Tomson", new Date(), true);

        try {
            user = userService.saveUser(user);
            logger.info("User " + user.getEmail() + " was saved. Registration date: " + user.getRegDate());

            user.setEmail("Will_Tomson@mail.ru");
            user = userService.saveUser(user);
            logger.info("User " + user.getEmail() + " was updated.");

            user = userService.deactivateUser(user.getId());
            logger.info("User " + user.getEmail() + " was deactivated. Active profile status: " + user.isActive());
            assertEquals(false, user.isActive());
        } catch (Exception ex) {
            logger.warn("User already exists or there was an error during the saving process.");
        }
    }

    @Test
    public void activeUserTest() {
        User user = userRepo.findByEmail(userConfig.getActiveUserEmail());
        assertEquals(user.getPassword(), userConfig.getActivePassword());
    }
}
