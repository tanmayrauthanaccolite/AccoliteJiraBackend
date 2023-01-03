package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Jira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JiraRepository extends JpaRepository<Jira,Long> {

        List<Jira> findBySprintOfJirasSprintId(long currentJiras);

}
