package com.jira.AccoliteJiraBackend.BusinessLogic;


import com.jira.AccoliteJiraBackend.Base.Jira;
import com.jira.AccoliteJiraBackend.Repository.JiraRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import com.jira.AccoliteJiraBackend.Service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class JiraComponent {

    @Autowired
    private JiraService jiraService;

    @Autowired
    private JiraRepository jiraRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private SprintComponent sprintComponent;

    @Autowired
    private SprintRepository sprintRepository;


    public long returnProjectId(String projectLabel){

        return projectRepository.findByProjectId(projectLabel);
    }

    public List<Jira> viewAllEpicsOfProject(long projectId){

           return this.jiraRepository.findByJiraprojectsProjectIdAndJiraType(projectId,"Epic");
    }

    public List<Jira> viewAllEpics(){
         return this.jiraRepository.findByJiraType("Epic");
    }

    public List<Jira> viewAllTasks(){
         return this.jiraRepository.findByJiraType("Task");
    }

    public List<Jira> viewAllJirasByEmployee(String alias){
           return this.jiraRepository.findByJiraAssigneeAndJiraType(alias,"Task");
    }

    public List<Jira> viewAllEpicsByEmployee(String alias){
         return this.jiraRepository.findByJiraAssigneeAndJiraType(alias,"Epic");
    }



}
