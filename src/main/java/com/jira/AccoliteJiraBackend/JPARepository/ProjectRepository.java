package com.jira.AccoliteJiraBackend.JPARepository;

import com.jira.AccoliteJiraBackend.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
