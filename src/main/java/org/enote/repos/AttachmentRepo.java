package org.enote.repos;

import org.enote.domain.Attachment;
import org.enote.domain.util.AttachmentEnum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachment, Integer> {

}
