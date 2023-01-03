package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.Employee;
import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Repository.EmployeeRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void createProject(Project project)
    {
        project.setActive(true);
        projectRepository.save(project);
    }

    public List<Project> viewAllProjects(){
         return projectRepository.findAll();
    }

    public List<String> getProjectDropdown(){

          return projectRepository.findByProjectLabel();
    }

    public Project viewProjectById(long projectId){

         return projectRepository.findByProjectId(projectId);
    }

    public ResponseEntity<Project> addEmployeeToProject(long projectId,long employeeId) {
        Optional<Employee> employeeOptional=this.employeeRepository.findById(employeeId);
        Optional<Project> projectOptional=this.projectRepository.findById(projectId);

        if(projectOptional.isPresent() && employeeOptional.isPresent())
        {

            Employee employee=employeeOptional.get();
            Project project=projectOptional.get();

            Set<Employee> s=project.getEmployees();

            project.getEmployees().add(employee);
            projectRepository.save(project);
            return new ResponseEntity<Project>(project, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
