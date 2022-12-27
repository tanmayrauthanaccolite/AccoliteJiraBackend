package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Entity.Employee;
import com.jira.AccoliteJiraBackend.Entity.Epic;
import com.jira.AccoliteJiraBackend.Entity.Project;
import com.jira.AccoliteJiraBackend.JPARepository.EpicRepository;
import com.jira.AccoliteJiraBackend.JPARepository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EpicService {

    @Autowired
    public EpicRepository epicRepository;

    @Autowired
    public ProjectRepository projectRepository;

    public ResponseEntity<Epic> createEpic(Epic epic)
    {
            Optional<Project> projectOptional=this.projectRepository.findById(epic.getProject().getProjectid());
            if(projectOptional.isPresent())
            {
                Project project=projectOptional.get();
                epic.setProject(project);
                System.out.println(epic.getProject().getProjectLabel());
                epicRepository.save(epic);
                return new ResponseEntity<>(epic, HttpStatus.CREATED);
            }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public List<Epic> listEpicsOfProject(long projectId)
    {
        return epicRepository.getEpicsFromProject(projectId);
    }

    public ResponseEntity<Epic> addEpicToProject(long epicId, long projectId) {
        Optional<Epic> epicOptional=this.epicRepository.findById(epicId);
        Optional<Project> projectOptional=this.projectRepository.findById(projectId);
        System.out.println("hi");
        if(projectOptional.isPresent() && epicOptional.isPresent())
        {
            System.out.println("hi2");
            Epic epic=epicOptional.get();
            Project project=projectOptional.get();
            epic.setProject(project);
            epicRepository.save(epic);
            return new ResponseEntity<Epic>(epic, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public List<Epic> listAllEpics() {
        return epicRepository.findAll();
    }
}
