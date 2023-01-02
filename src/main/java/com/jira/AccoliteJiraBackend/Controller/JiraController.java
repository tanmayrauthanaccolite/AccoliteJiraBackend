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

    @PostMapping("/addjira")
    private ResponseEntity<Jira> createJira(@RequestBody Jira jira){
         return new ResponseEntity<>(jiraService.createJira(jira),HttpStatus.OK);
    }
}
