package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.BusinessLogic.ProjectComponent;
import com.jira.AccoliteJiraBackend.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @Autowired
    public ProjectComponent projectComponent;

    @GetMapping("/viewProject")
    public ResponseEntity<List<Project>> viewAllProjects(){
          return ResponseEntity.ok().body(this.projectService.viewAllProjects());
    }

    @GetMapping("/viewProjectbyId/{projectId}")
    public ResponseEntity<Project> viewProjectById(@PathVariable("projectId") long projectId){
         return ResponseEntity.ok().body(this.projectService.viewProjectById(projectId));
    }

    @GetMapping("/projectdropdown")
    public ResponseEntity<List<String>> getProjectDropdown(){
         return ResponseEntity.ok().body(this.projectService.getProjectDropdown());
    }

    @GetMapping("/sprintdropdown/{projectId}")
    public ResponseEntity<Set<Sprint>> getSprintDropdown(@PathVariable("projectId") long projectId){
        return ResponseEntity.ok().body(this.projectService.getSprintDropdown(projectId));
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

    @PutMapping("/add/employee/{projectId}/project/{alias}")
    public ResponseEntity<Project> addEmployeeToProject(@PathVariable("projectId") long projectId, @PathVariable("alias") String alias)
    {
        try {
            return projectService.addEmployeeToProject(projectId,alias);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/remove/employee/{projectId}/project/{employeeId}")
    public void removeEmployeeFromProject(@PathVariable("projectId") long projectId, @PathVariable("employeeId") long employeeId){
            projectComponent.removeEmployeeFromProject(projectId,employeeId);

    }

    @GetMapping("/viewProjectbyAlias/{alias}")
    public Set<Project> viewAllProjectsByEmployeeId(@PathVariable("alias") String alias){
        return projectComponent.viewAllProjectsByAlias(alias);
    }
}
