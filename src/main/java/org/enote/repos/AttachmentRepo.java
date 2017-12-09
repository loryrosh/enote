package org.enote.repos;

import org.enote.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepo extends JpaRepository<Attachment, Integer> {

}
