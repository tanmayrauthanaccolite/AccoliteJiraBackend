package com.jira.AccoliteJiraBackend.Controller;


import com.jira.AccoliteJiraBackend.Base.Tasks;
import com.jira.AccoliteJiraBackend.Exceptions.CurrentTaskPhaseException;
import com.jira.AccoliteJiraBackend.Exceptions.NoSuchTaskException;
import com.jira.AccoliteJiraBackend.Service.TaskService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @PostMapping("/addTasks")
    private @NotNull ResponseEntity<Tasks> addTasks(@RequestBody Tasks t){
        return ResponseEntity.ok().body(this.taskService.addTasks(t));
    }

    @GetMapping("/viewTasks")
    private ResponseEntity<List<Tasks>> viewTasks(){
        return ResponseEntity.ok().body(this.taskService.viewAllTasks());
    }

    @GetMapping("/{taskId}")
    private ResponseEntity<Tasks> viewTask(@PathVariable int taskId)  {
        try {
            return ResponseEntity.ok().body(this.taskService.viewTask(taskId));
        } catch (NoSuchTaskException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{taskId}/sprint/{sprintId}")
    private Tasks mapTasks(@PathVariable int taskId, @PathVariable int sprintId){
           return taskService.mapTasks(taskId,sprintId);
    }

    @PutMapping("/{taskId}/{taskPhase}")
    private Tasks taskPhase(@PathVariable int taskId, @PathVariable String taskPhase) {
        try {
            return taskService.taskPhase(taskId,taskPhase);
        } catch (CurrentTaskPhaseException e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }

    }


}
