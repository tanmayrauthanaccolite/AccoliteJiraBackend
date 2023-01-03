package com.jira.AccoliteJiraBackend.BusinessLogic;


import com.jira.AccoliteJiraBackend.Repository.JiraRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import com.jira.AccoliteJiraBackend.Service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


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



}
