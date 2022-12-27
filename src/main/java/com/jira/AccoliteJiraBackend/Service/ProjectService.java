package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Entity.Employee;
import com.jira.AccoliteJiraBackend.Entity.Epic;
import com.jira.AccoliteJiraBackend.Entity.Project;
import com.jira.AccoliteJiraBackend.JPARepository.EmployeeRepository;
import com.jira.AccoliteJiraBackend.JPARepository.EpicRepository;
import com.jira.AccoliteJiraBackend.JPARepository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    public ProjectRepository projectRepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    public void createProject(Project project)
    {
        projectRepository.save(project);
    }

    public ResponseEntity<Project> addEmployeeToProject(long employeeId, long projectId) {
        Optional<Employee> employeeOptional=this.employeeRepository.findById(employeeId);
        Optional<Project> projectOptional=this.projectRepository.findById(projectId);
        System.out.println("hi");
        if(projectOptional.isPresent() && employeeOptional.isPresent())
        {
            System.out.println("hi2");
            Employee employee=employeeOptional.get();
            Project project=projectOptional.get();
            System.out.println(employee.getAlias());
            System.out.println(project.getProjectLabel());
            Set<Employee> s=project.getEmployees();
            System.out.println(s.size());
            System.out.println("hi3");
            project.getEmployees().add(employee);
            projectRepository.save(project);
            return new ResponseEntity<Project>(project, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
