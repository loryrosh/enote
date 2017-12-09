package org.enote.repos;

import org.enote.domain.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabelRepo extends JpaRepository<Label, Integer> {

}
