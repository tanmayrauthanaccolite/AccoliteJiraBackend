package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Jira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JiraRepository extends JpaRepository<Jira,Long> {

//      Long findByJiraProjectsProjectId(String projectLabel);
}
