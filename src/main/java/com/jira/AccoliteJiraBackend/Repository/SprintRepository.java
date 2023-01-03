package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface SprintRepository extends JpaRepository<Sprint,Long> {

    @Query(value = "SELECT sprintid FROM sprints t WHERE t.iscurrent=true",nativeQuery = true)
    long findBySprintOfProjectProjectId(long projectId);
}
