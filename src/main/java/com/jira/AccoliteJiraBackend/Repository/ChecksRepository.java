package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Checks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChecksRepository extends JpaRepository<Checks,Integer> {

    @Query(value = "select flag from checks",nativeQuery = true)
    int findByJirastateJiraId(long jiraId);
}
