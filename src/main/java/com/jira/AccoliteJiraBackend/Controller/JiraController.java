package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Jira;
import com.jira.AccoliteJiraBackend.BusinessLogic.JiraComponent;
import com.jira.AccoliteJiraBackend.Service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jira")
public class JiraController {

    @Autowired
    public JiraService jiraService;

    @Autowired
    public JiraComponent jiraComponent;


    @GetMapping("/alljiras")
    private ResponseEntity<List<Jira>> viewAllJiras(){
           return new ResponseEntity<List<Jira>>(jiraService.viewAllJiras(), HttpStatus.OK);
    }

    @GetMapping("/jiraprojectid/{projectLabel}")
    private ResponseEntity<Long> returnProjectId(@PathVariable("projectLabel") String projectLabel){
          return new ResponseEntity<>(jiraComponent.returnProjectId(projectLabel),HttpStatus.OK);
    }

    @GetMapping("/jirabyid/{jiraId}")
    private ResponseEntity<Jira> viewJiraById(@PathVariable("jiraId") Long jiraId){
        return new ResponseEntity<>(jiraService.viewJiraById(jiraId),HttpStatus.OK);
    }

    @GetMapping("/getEpics/{projectId}")
    private ResponseEntity<List<Jira>> viewAllEpicsOfProject(@PathVariable("projectId") long projectId){
         return new ResponseEntity<>(jiraComponent.viewAllEpicsOfProject(projectId),HttpStatus.OK);
    }

    @GetMapping("/getAllTasks")
    private ResponseEntity<List<Jira>> viewAllTasks(){
        return new ResponseEntity<>(jiraComponent.viewAllTasks(),HttpStatus.OK);
    }

    @GetMapping("/getAllEpics")
    private ResponseEntity<List<Jira>> viewAllEpics(){
        return new ResponseEntity<>(jiraComponent.viewAllEpics(),HttpStatus.OK);
    }

    @GetMapping("/getAllJirasOfEmployee/{jiraAssignee}")
    public ResponseEntity<List<Jira>> viewAllJirasByEmployee(@PathVariable("jiraAssignee") String jiraAssignee){
          return new ResponseEntity<>(jiraComponent.viewAllJirasByEmployee(jiraAssignee),HttpStatus.OK);
    }

    @GetMapping("/getAllEpicsOfEmployee/{jiraAssignee}")
    public ResponseEntity<List<Jira>> viewAllEpicsByEmployee(@PathVariable("jiraAssignee") String jiraAssignee){
        return new ResponseEntity<>(jiraComponent.viewAllEpicsByEmployee(jiraAssignee),HttpStatus.OK);
    }


    @PostMapping("/addjira")
    private ResponseEntity<Jira> createJira(@RequestBody Jira jira){
         return new ResponseEntity<>(jiraService.createJira(jira),HttpStatus.OK);
    }

    @PutMapping("/updateJira/{jiraId}")
    private void updateJiraById(@PathVariable("jiraId") long jiraId,@RequestBody Jira jira){
          jiraService.updateJiraById(jiraId,jira);
    }
    @DeleteMapping("/deletejira/{jiraId}")
    private void deleteJiraById(@PathVariable("jiraId") long jiraId){
         jiraService.deleteJiraById(jiraId);
    }
}
