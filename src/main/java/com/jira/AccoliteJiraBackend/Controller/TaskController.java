package com.jira.AccoliteJiraBackend.Controller;


import com.jira.AccoliteJiraBackend.Base.Tasks;
import com.jira.AccoliteJiraBackend.Exceptions.NoSuchTaskException;
import com.jira.AccoliteJiraBackend.Service.TaskService;
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
    private Tasks addTasks(@RequestBody Tasks t){
        return taskService.addTasks(t);
    }

    @GetMapping("/viewTasks")
    private ResponseEntity<List<Tasks>> viewTasks(){
        return ResponseEntity.ok().body(this.taskService.viewAllTasks());
    }

    @GetMapping("/{taskId}")
    private ResponseEntity<Tasks> viewTask(@PathVariable int taskId){
        try {
            return ResponseEntity.ok().body(this.taskService.viewTask(taskId));
        } catch (NoSuchTaskException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/epic/{epicId}")
    private ResponseEntity<List<Tasks>> findAllTasksOfEpic(@PathVariable long epicId){
          return ResponseEntity.ok().body(this.taskService.findAllTasksOfEpic(epicId));
    }

    @GetMapping("/view/{employeeAlias}")
    private ResponseEntity<List<Tasks>> findAllTasksOfEmployee(@PathVariable("employeeAlias") String employeeAlias){
        return ResponseEntity.ok().body(this.taskService.findTasksOfEmployee(employeeAlias));
    }



}
