package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.Base.Tasks;
import com.jira.AccoliteJiraBackend.Exceptions.NoSuchSprintException;
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
public class SprintService  {

    @Autowired
    private SprintRepository sprintRepository;
    @Autowired
    private TaskRepository taskRepository;

    public Sprint addSprints(Sprint st){

        return sprintRepository.save(st);
    }

    public Sprint viewSprint(int sprintId) throws NoSuchSprintException {

        Optional<Sprint> sprintObj = this.sprintRepository.findById(sprintId);

        if(sprintObj.isPresent()){
            return sprintObj.get();
        }else{
            throw new NoSuchSprintException("No Such Sprints Found");
        }
    }

    public List<Sprint> viewSprints(){

        return this.sprintRepository.findAll();
    }

    public Sprint mapSprints(int sprintId, int taskId){

        Set<Tasks> emptasks = null;
        Sprint sprint = sprintRepository.findById(sprintId).get();
        Tasks tasks =  taskRepository.findById(taskId).get();
        emptasks = sprint.getSprinttasks();
        emptasks.add(tasks);
        sprint.setSprinttasks(emptasks);
        return sprintRepository.save(sprint);

    }







}
