package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Jira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JiraRepository extends JpaRepository<Jira,Long> {

        List<Jira> findBySprintOfJirasSprintIdAndJiraType(long currentJiras,String jiraType);

        List<Jira> findByJiraprojectsProjectIdAndJiraType(long projectId,String jiraType);

        List<Jira> findByJiraType(String jiraType);

        List<Jira> findByJiraAssigneeAndJiraType(String jiraAssignee,String jiraType);
        Optional<Jira> findByJiraId(long jiraId);

//        Jira findByJiraId(long jiraId);

        List<Jira> findByJiraepicJiraId(long jiraId);

        @Query(value = "select e from Jira e where e.jirastatus='To-Do' or e.jirastatus='In Progress' ",nativeQuery = true)
        List<Jira> getByEmployeeEmployeeIdAndJiraprojectsProjectIdAndJiraType(long employeeId, long projectId, String jiraType);

        List<Jira> findByEmployeeEmployeeIdAndJiraprojectsProjectIdAndJiraType(long employeeId, long projectId, String jiraType);

//        @Query(value="select j from Jira j where j.jiraType=:type and j.jiraSprint=:sprintid")
//        List<Jira> findTasksOfCurrentSprintOfProject(@Param("type") String type, @Param("sprintid") String sprintid);

        @Query(value = "select jiraid from jira",nativeQuery = true)
        List<Long> findByEmployeeEmployeeIdAndJiraTypeAndJiraprojectsProjectId(long employeeId,String jiraType,long projectId);

        @Query(value = "SELECT * FROM jira WHERE jiratype='Task' AND jiraid NOT IN(SELECT jira_id FROM sprint_jira);",nativeQuery = true)
        List<Jira> getUnAddedSprints();

        List<Jira> findByEmployeeEmployeeIdAndJiraprojectsProjectIdAndJiraType(String employeeId, String projectId,String jiraType);
}

