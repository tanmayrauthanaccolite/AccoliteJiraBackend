package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Employee;
import com.jira.AccoliteJiraBackend.Base.Epic;
import com.jira.AccoliteJiraBackend.Base.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks,Integer> {

    @Query(value="SELECT t FROM Tasks t WHERE t.taskid.taskphase =?1",nativeQuery = true)
    String getTaskPhase(@PathVariable int taskId, @Param("taskPhase") String taskPhase);

    List<Tasks> findByTaskOfEpicEpicId(Long epicId);


//    @Query("select t from Tasks t where t.taskAssignee=:alias")
//    public List<Tasks> getTasksOfEmployee(@Param("alias") String alias);

//    @Query("select t from Tasks t where t.taskAssignee=:alias")
    public List<Tasks> findByTaskAssignee(String alias);

}
