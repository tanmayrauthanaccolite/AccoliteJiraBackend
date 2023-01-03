package com.jira.AccoliteJiraBackend.BusinessLogic;

import com.jira.AccoliteJiraBackend.Base.Employee;
import com.jira.AccoliteJiraBackend.Base.Project;
import com.jira.AccoliteJiraBackend.Repository.EmployeeRepository;
import com.jira.AccoliteJiraBackend.Repository.ProjectRepository;
import com.jira.AccoliteJiraBackend.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class ProjectComponent {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public void removeEmployeeFromProject(long projectId, long employeeId) {
        Optional<Employee> employeeOptional=this.employeeRepository.findById(employeeId);
        Optional<Project> projectOptional=this.projectRepository.findById(projectId);

        if(projectOptional.isPresent() && employeeOptional.isPresent())
        {

            Employee employee=employeeOptional.get();
            Project project=projectOptional.get();

            project.getEmployees().remove(employee);
            projectRepository.save(project);
        }
    }
}
