package org.enote.repos;

import org.enote.domain.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotebookRepo extends JpaRepository<Notebook, Integer> {

}
