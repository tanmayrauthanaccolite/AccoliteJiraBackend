package com.jira.AccoliteJiraBackend.BusinessLogic;

import com.jira.AccoliteJiraBackend.Base.Jira;
import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Base.Sprint;
import com.jira.AccoliteJiraBackend.Repository.JiraRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import com.jira.AccoliteJiraBackend.Repository.TaskRepository;
import com.jira.AccoliteJiraBackend.Service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SprintComponent {

    @Autowired
    private SprintService sprintService;
    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private JiraRepository jiraRepository;

    public ResponseEntity<Sprint> mapJiraSprints(int sprintId, long jiraId) {

        Optional<Sprint> sprintObj = this.sprintRepository.findById(sprintId);
        Optional<Jira> jiraObj = this.jiraRepository.findById(jiraId);

        if (sprintObj.isPresent() && jiraObj.isPresent()) {

            Sprint sprint = sprintObj.get();
            Jira jiras = jiraObj.get();

            List<Jira> j = sprint.getJirasOfSprint();
            sprint.getJirasOfSprint().add(jiras);
            sprintRepository.save(sprint);
            return new ResponseEntity<>(sprint, HttpStatus.CREATED);

        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }

    public ResponseEntity<Sprint> addSprintToProject(int sprintId, long projectId) {
        Optional<Sprint> sprintObj=this.sprintRepository.findById(sprintId);
        Optional<Project> projectObj=this.projectRepository.findById(projectId);
        if(projectObj.isPresent() && sprintObj.isPresent())
        {
            Sprint sprints=sprintObj.get();
            Project project=projectObj.get();
            sprints.setSprintOfProject(project);
            sprintRepository.save(sprints);
            return new ResponseEntity<>(sprints, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    public Sprint viewCurrentSprint(){

           Long projectObj = this.projectRepository.findByProjectId();
           return sprintRepository.findByProjectSprintId(projectObj);

    }

}
