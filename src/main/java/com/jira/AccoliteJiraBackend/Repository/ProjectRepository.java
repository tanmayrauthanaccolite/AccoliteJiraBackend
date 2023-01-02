package com.jira.AccoliteJiraBackend.Repository;


import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Base.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
    Project findByProjectId(long projectId);

    @Query(value = "SELECT projectid FROM Project t WHERE t.projectLabel=?1",nativeQuery = true)
    Long findByProjectId(String projectLabel);

    @Query(value = "SELECT * FROM Project t WHERE t.isactive=?1",nativeQuery = true)
    Long findByProjectId();


}
