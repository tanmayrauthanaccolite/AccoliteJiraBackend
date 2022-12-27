package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.Base.Tasks;
import com.jira.AccoliteJiraBackend.Exceptions.CurrentTaskPhaseException;
import com.jira.AccoliteJiraBackend.Exceptions.NoSuchTaskException;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import com.jira.AccoliteJiraBackend.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Transactional
public class TaskService {

          @Autowired
          private TaskRepository taskrepository;

          @Autowired
          private SprintRepository sprintRepository;

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

          public Tasks mapTasks(int taskId,int sprintId){

               Set<Sprint> currentSprint = null;
               Tasks tasks = this.taskrepository.findById(taskId).get();
               Sprint sprint = this.sprintRepository.findById(sprintId).get();
               currentSprint=tasks.getSprints();
               currentSprint.add(sprint);
               tasks.setSprints(currentSprint);
               return this.taskrepository.save(tasks);

          }


          public Tasks taskPhase(int taskId, String taskPhase) throws CurrentTaskPhaseException {

                 Optional<Tasks> phaseObj = this.taskrepository.findById(taskId);
                 if(phaseObj.isPresent()){
                    Tasks t = phaseObj.get();
                    t.setTaskPhase(taskPhase);
                    t.setTaskPoints(t.getTaskPoints());
                    return taskrepository.save(t);
                 }else {
                       throw new CurrentTaskPhaseException("Current Phase is the Selected Phase.Select a Different Phase");
                }
          }
}
