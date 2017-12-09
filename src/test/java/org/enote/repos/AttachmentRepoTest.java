package org.enote.repos;

import org.enote.config.DataSourceConfigTest;
import org.enote.config.TestPreConfig;
import org.enote.domain.Attachment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
public class AttachmentRepoTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);

    @Autowired
    private AttachmentRepo attachmentRepo;

    @Test
    public void checkTotalAmount() {
        long count = attachmentRepo.count();
        logger.info("Total amount of attachment types: " + count);

        assertEquals(4, count);
    }

    @Test
    public void showAll() {
        List<Attachment> attachments = attachmentRepo.findAll();
        attachments.stream().forEach(attachment -> logger.info(attachment.getAttr()));
    }
}
