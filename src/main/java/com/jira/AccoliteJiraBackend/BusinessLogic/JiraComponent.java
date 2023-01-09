package com.jira.AccoliteJiraBackend.BusinessLogic;


import com.jira.AccoliteJiraBackend.Base.Jira;
import com.jira.AccoliteJiraBackend.Repository.ChecksRepository;
import com.jira.AccoliteJiraBackend.Repository.JiraRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import com.jira.AccoliteJiraBackend.Repository.SprintRepository;
import com.jira.AccoliteJiraBackend.Service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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

    @Autowired
    private ChecksRepository checksRepository;


    public long returnProjectId(String projectLabel){

        return projectRepository.findByProjectId(projectLabel);
    }

    public long projectIdByJiraId(long jiraId) {
        Optional<Jira> jiraObj = this.jiraRepository.findByJiraId(jiraId);
        Jira jira = jiraObj.get();
        return jira.getJiraprojects().getProjectId();
    }



    public List<Jira> viewAllEpicsOfProject(long projectId){

           return this.jiraRepository.findByJiraprojectsProjectIdAndJiraType(projectId,"Epic");
    }

    public List<Jira> viewTasksOfEpic(long jiraId){
        return this.jiraRepository.findByJiraepicJiraId(jiraId);
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


    public List<Jira> epicOfEmployeeOfProject(long employeeId,long projectId){

        return this.jiraRepository.findByEmployeeEmployeeIdAndJiraprojectsProjectIdAndJiraType(employeeId,projectId,"Epic");
    }

    public List<Jira> tasksOfEmployeeOfProject(long employeeId,long projectId){

        return this.jiraRepository.findByEmployeeEmployeeIdAndJiraprojectsProjectIdAndJiraType(employeeId,projectId,"Task");
    }

    public List<Jira> tasksOfEmployeeOfProjectExceptDone(long employeeId,long projectId){

        return this.jiraRepository.getByEmployeeEmployeeIdAndJiraprojectsProjectIdAndJiraType(employeeId,projectId,"Task");
    }

    public List<Jira> jirasUnAddedToSprints(Long employeeId,Long projectId) {

        List<Long> listOfEmp = this.jiraRepository.findByEmployeeEmployeeIdAndJiraTypeAndJiraprojectsProjectId(employeeId,"Task",projectId);
        List<Jira> jirasLeft = this.jiraRepository.getUnAddedSprints();
        List<Jira> jirasUnAdded = new ArrayList<>();

        for ( int i=0;i<jirasLeft.size();i++){
            for(int j=0;j<listOfEmp.size();j++){
                long x = jirasLeft.get(i).getJiraId();
                long y = listOfEmp.get(j);
                if(x==y){
                    jirasUnAdded.add(jirasLeft.get(i));
                }
            }
        }

        return jirasUnAdded;

    }


}
