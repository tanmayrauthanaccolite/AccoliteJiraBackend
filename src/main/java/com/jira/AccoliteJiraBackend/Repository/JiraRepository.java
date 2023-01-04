package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Jira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JiraRepository extends JpaRepository<Jira,Long> {

        List<Jira> findBySprintOfJirasSprintIdAndJiraType(long currentJiras,String jiraType);

        List<Jira> findByJiraprojectsProjectIdAndJiraType(long projectId,String jiraType);

        List<Jira> findByJiraType(String jiraType);

        List<Jira> findByJiraAssigneeAndJiraType(String jiraAssignee,String jiraType);

}
