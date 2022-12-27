package com.jira.AccoliteJiraBackend.JPARepository;

import com.jira.AccoliteJiraBackend.Entity.Epic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EpicRepository extends JpaRepository<Epic, Long> {

    @Query("SELECT e FROM Epic e WHERE e.project.projectid = :projectId")
    public List<Epic> getEpicsFromProject(@Param("projectId") long projectId);
}
