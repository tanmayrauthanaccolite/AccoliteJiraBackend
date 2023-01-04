package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.Jira;
import com.jira.AccoliteJiraBackend.Repository.JiraRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JiraService {

     @Autowired
     private JiraRepository jiraRepository;

     @Autowired
     private ProjectRepository projectRepository;

     public Jira createJira(Jira jira){
         jira.setJiraStatus("To-Do");
         jira.setJiraprojects(projectRepository.findByProjectId(jira.getJiraprojects().getProjectId()));
         return jiraRepository.save(jira);
     }

     public List<Jira> viewAllJiras(){

         return jiraRepository.findAll();
     }

     public Jira viewJiraById(long jiraId){

         Optional<Jira> jiraObj = this.jiraRepository.findById(jiraId);
         return jiraObj.get();
     }

     public void updateJiraById(long jiraId,Jira jira){
             jiraRepository.save(jira);
     }

     public void deleteJiraById(long jiraId){
           jiraRepository.deleteById(jiraId);
     }







}
