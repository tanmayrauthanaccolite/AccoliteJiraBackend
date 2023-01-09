package com.jira.AccoliteJiraBackend.Repository;


import com.jira.AccoliteJiraBackend.Base.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Set;


@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project findByProjectId(long projectId);

    @Query(value = "SELECT projectid FROM Project t WHERE t.projectLabel=?1 ",nativeQuery = true)
    long findByProjectId(String projectLabel);

    @Query(value = "SELECT projectLabel FROM Project",nativeQuery = true)
    List<String> findByProjectLabel();

    Set<Project> findByEmployeesAlias(String alias);

//    @Query(value = "SELECT projectid FROM Project t WHERE t.projectLabel=?1 ",nativeQuery = true)
//    long findByProjectId(String projectLabel);
}
