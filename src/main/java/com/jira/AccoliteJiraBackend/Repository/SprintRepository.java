package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;


@Repository
public interface SprintRepository extends JpaRepository<Sprint,Integer> {

         @Query(value = "SELECT * FROM Sprint t WHERE t.iscurrent=true AND t.projectsprintid=?1",nativeQuery = true)
         Sprint findByProjectSprintId(@PathVariable("projectId") Long projectId);

}
