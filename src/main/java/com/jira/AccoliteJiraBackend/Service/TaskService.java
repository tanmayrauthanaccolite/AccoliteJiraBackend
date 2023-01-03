package com.jira.AccoliteJiraBackend.Service;


import com.jira.AccoliteJiraBackend.Base.Tasks;
import com.jira.AccoliteJiraBackend.Exceptions.NoSuchTaskException;
import com.jira.AccoliteJiraBackend.Repository.EpicRepository;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import com.jira.AccoliteJiraBackend.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

          @Autowired
          private TaskRepository taskrepository;

          @Autowired
          private SprintRepository sprintRepository;

          @Autowired
          private EpicRepository epicRepository;

          public Tasks addTasks(Tasks tsk){

              return taskrepository.save(tsk);
          }

          public Tasks viewTask(int taskId) throws NoSuchTaskException {

               Optional<Tasks> taskObj = this.taskrepository.findById(taskId);

               if(taskObj.isPresent()){
                    return taskObj.get();
               }else {
                   throw new NoSuchTaskException("No Such Tasks Found.");
               }
          }

          public List<Tasks> viewAllTasks(){

              return this.taskrepository.findAll();
          }

          public List<Tasks> findAllTasksOfEpic(long epicId){

                  return taskrepository.findByTaskOfEpicEpicId(epicId);

          }

    public List<Tasks> findTasksOfEmployee(String alias){

        return taskrepository.findByTaskAssignee(alias);

    }

}
