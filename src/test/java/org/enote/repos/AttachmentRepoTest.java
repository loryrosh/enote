package org.enote.repos;

import org.enote.TestPreConfig;
import org.enote.config.DataSourceConfig;
import org.enote.config.PersistenceConfig;
import org.enote.domain.Attachment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, DataSourceConfig.class})
public class AttachmentRepoTest extends TestPreConfig {

    private Logger logger = LoggerFactory.getLogger(AttachmentRepoTest.class);

    @Autowired
    private AttachmentRepo attachmentRepo;

    @Test
    public void checkTotalAmount() {
        long count = attachmentRepo.count();
        logger.info("Total amount of attachment types: " + count);
    }

    @Test
    public void showAll() {
        List<Attachment> attachments = attachmentRepo.findAll();
        attachments.stream().forEach(attachment -> logger.info(attachment.getAttr()));
    }
}
