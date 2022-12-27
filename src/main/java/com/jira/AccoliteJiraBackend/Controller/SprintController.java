package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.Exceptions.NoSuchSprintException;
import com.jira.AccoliteJiraBackend.Service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    public SprintService sprintService;

    @PostMapping("/addSprint")
    private ResponseEntity<Sprint> addSprints(@RequestBody Sprint s){
             return ResponseEntity.ok().body(this.sprintService.addSprints(s));
    }

    @GetMapping("/viewSprint")
    private ResponseEntity<List<Sprint>> viewSprints(){
          return ResponseEntity.ok().body(this.sprintService.viewSprints());
    }

    @GetMapping("/{sprintId}")
    private ResponseEntity<Sprint> viewSprint(@PathVariable int sprintId)  {
        try {
            return ResponseEntity.ok().body(this.sprintService.viewSprint(sprintId));
        } catch (NoSuchSprintException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{sprintId}/tasks/{taskId}")
    private Sprint mapSprints(@PathVariable int sprintId , @PathVariable int taskId ){
        return sprintService.mapSprints(sprintId,taskId);

    }

}
