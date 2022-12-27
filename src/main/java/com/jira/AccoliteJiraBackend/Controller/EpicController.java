package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Entity.Epic;
import com.jira.AccoliteJiraBackend.Entity.Project;
import com.jira.AccoliteJiraBackend.Service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EpicController {

    @Autowired
    public EpicService epicService;

    @PostMapping("/epic")
    public ResponseEntity<Epic> createEpic(@RequestBody Epic epic)
    {
        return epicService.createEpic(epic);
    }
    @GetMapping("/project/epic/{project_Id}")
    public ResponseEntity<List<Epic>> listEpicsOfProject(@PathVariable("project_Id") long id){
        return new ResponseEntity<List<Epic>>(epicService.listEpicsOfProject(id),HttpStatus.OK);
    }
    @GetMapping("/project/epic")
    public ResponseEntity<List<Epic>> listAllEpics(){
        return new ResponseEntity<List<Epic>>(epicService.listAllEpics(),HttpStatus.OK);
    }
    @PutMapping("/add/epic/{epicId}/project/{projectId}")
    public ResponseEntity<Epic> addEpicToProject(@PathVariable("epicId") long epicId, @PathVariable("projectId") long projectId)
    {
        try {
            return epicService.addEpicToProject(epicId, projectId);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
