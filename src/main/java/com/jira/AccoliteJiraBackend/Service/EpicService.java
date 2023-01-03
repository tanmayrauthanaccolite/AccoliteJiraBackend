package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.Epic;
import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Repository.EpicRepository;

import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Builder
@Service
@Transactional
public class EpicService {

    @Autowired
    private EpicRepository epicRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public ResponseEntity<Epic> addEpic(Epic epic){

        epicRepository.save(epic);
        return new ResponseEntity<>(epic, HttpStatus.CREATED);
    }
    public List<Epic> listEpicsOfProject(long projectId) {

        return epicRepository.getEpicsFromProject(projectId);
    }
    public List<Epic> listAllEpics() {

        return epicRepository.findAll();
    }

    public Epic updateEpic(Epic epic){

        Optional<Epic> epicObj = this.epicRepository.findById(epic.getEpicId());

        if(epicObj.isPresent()){
              Epic e = epicObj.get();
              e.setEpicLabel(epic.getEpicLabel());
              e.setEpicDescription(epic.getEpicDescription());
              e.setStatus(epic.getStatus());
              e.setAssignee(epic.getAssignee());
              e.setPriority(epic.getPriority());
              return epicRepository.save(epic);
        }else{
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
