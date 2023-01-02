package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @GetMapping("/viewProject")
    public ResponseEntity<List<Project>> viewAllProjects(){
          return ResponseEntity.ok().body(this.projectService.viewAllProjects());
    }

    @GetMapping("/viewProjectbyId/{projectId}")
    public ResponseEntity<Project> viewProjectById(@PathVariable("projectId") long projectId){
         return ResponseEntity.ok().body(this.projectService.viewProjectById(projectId));
    }

    @PostMapping("/project")
    public ResponseEntity<Project> createProject(@RequestBody Project project)
    {
        try {
            projectService.createProject(project);
            return new ResponseEntity<>(project, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/add/employee/{projectId}/project/{employeeId}")
    public ResponseEntity<Project> addEmployeeToProject(@PathVariable("projectId") long projectId, @PathVariable("employeeId") long employeeId)
    {
        try {
            return projectService.addEmployeeToProject(projectId,employeeId);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
