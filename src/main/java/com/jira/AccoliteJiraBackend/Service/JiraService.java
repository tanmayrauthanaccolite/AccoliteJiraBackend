package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.Jira;
import com.jira.AccoliteJiraBackend.Repository.JiraRepository;
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

     public Jira createJira(Jira jira){

         return jiraRepository.save(jira);
     }

     public List<Jira> viewAllJiras(){

         return jiraRepository.findAll();
     }

     public Jira viewJiraById(long jiraId){

         Optional<Jira> jiraObj = this.jiraRepository.findById(jiraId);
         return jiraObj.get();
     }







}
