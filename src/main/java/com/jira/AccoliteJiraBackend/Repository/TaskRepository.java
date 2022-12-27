package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Tasks,Integer> {

    @Query(value="SELECT i FROM tasks i where i.taskPhase=?1",nativeQuery = true)
    Optional<Tasks> findByString(@Param("taskPhase") String taskPhase);

    //Queries
}
