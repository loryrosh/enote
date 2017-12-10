package org.enote.repos;

import org.enote.config.DataSourceConfigTest;
import org.enote.TestPreConfig;
import org.enote.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepoTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);

    @Autowired
    private UserRepo userRepo;

    @Test
    public void checkTotalAmountTest() {
        long count = userRepo.count();
        logger.info("Total amount of users: " + count);
    }

    @Test
    public void showAllTest() {
        List<User> users = userRepo.findAll();
        users.stream().forEach(user -> logger.info(user.getName() + " " + user.getEmail()));
    }

    @Test
    public void findUserTest() {
        Optional<User> foundUser = userRepo.findById(2);
        if (foundUser.isPresent()) {
            logger.info("Found user with id 2: " + foundUser.get().getEmail());
            assertEquals("Andy@mail.ru", foundUser.get().getEmail());
        }
    }
}
