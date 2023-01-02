package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.BusinessLogic.SprintComponent;
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

    @Autowired
    public SprintComponent sprintComponent;

    @PostMapping("/addSprint")
    private ResponseEntity<Sprint> addSprints(@RequestBody Sprint s){
           return new ResponseEntity<>(sprintService.addSprints(s),HttpStatus.OK);
    }

    @GetMapping("/viewSprint")
    private ResponseEntity<List<Sprint>> viewSprints(){
        return new ResponseEntity<>(sprintService.viewSprints(),HttpStatus.OK);
    }

    @GetMapping("/{sprintId}")
    private ResponseEntity<Sprint> viewSprint(@PathVariable int sprintId)  {
        try {
            return new ResponseEntity<>(sprintService.viewSprint(sprintId),HttpStatus.OK);
        } catch (NoSuchSprintException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/currentsprint")
    private ResponseEntity<Sprint> viewCurrentSprint(){
          return new ResponseEntity<>(sprintComponent.viewCurrentSprint(),HttpStatus.OK);
    }

    @PutMapping("/{sprintId}/jiras/{jiraId}")
    private ResponseEntity<Sprint> mapJiraSprints(@PathVariable("sprintId") int sprintId , @PathVariable("jiraId") long jiraId ){
        return sprintComponent.mapJiraSprints(sprintId,jiraId);
    }

    @PutMapping("/{sprintId}/projects/{projectId}")
    private ResponseEntity<Sprint> addSprintToProject(@PathVariable("sprintId") int sprintId, @PathVariable("projectId") long projectId ){

        try {
            return sprintComponent.addSprintToProject(sprintId,projectId);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
