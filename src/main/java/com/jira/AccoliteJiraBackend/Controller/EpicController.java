package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Epic;
import com.jira.AccoliteJiraBackend.Service.EpicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/epics")
public class EpicController {
    @Autowired
    public EpicService epicService;

    @PostMapping("/epic")
    public ResponseEntity<Epic> addEpic(@RequestBody Epic epic){
        return epicService.addEpic(epic);
    }

    @GetMapping("/project/epic/{project_Id}")
    public ResponseEntity<List<Epic>> listEpicsOfProject(@PathVariable("project_Id") long id){
        return new ResponseEntity<List<Epic>>(epicService.listEpicsOfProject(id), HttpStatus.OK);
    }
    @GetMapping("/project/epic")
    public ResponseEntity<List<Epic>> listAllEpics(){
        return new ResponseEntity<List<Epic>>(epicService.listAllEpics(),HttpStatus.OK);
    }

    @PutMapping("/updateEpic/{epicId}")
    public ResponseEntity<Epic> updateEpic(@PathVariable("epicId") long epicId,@RequestBody Epic epic){
        epic.setEpicId(epicId);
        return new ResponseEntity<Epic>(epicService.updateEpic(epic),HttpStatus.OK);
    }
}
