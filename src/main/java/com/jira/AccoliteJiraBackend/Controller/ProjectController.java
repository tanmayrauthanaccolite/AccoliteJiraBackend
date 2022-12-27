package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Entity.Epic;
import com.jira.AccoliteJiraBackend.Entity.Project;
import com.jira.AccoliteJiraBackend.Service.EpicService;
import com.jira.AccoliteJiraBackend.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProjectController {
    @Autowired
    public ProjectService projectService;

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

    @PutMapping("/add/employee/{employeeId}/project/{projectId}")
    public ResponseEntity<Project> addEmployeeToProject(@PathVariable("employeeId") long employeeId, @PathVariable("projectId") long projectId)
    {
        try {
            return projectService.addEmployeeToProject(employeeId, projectId);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
