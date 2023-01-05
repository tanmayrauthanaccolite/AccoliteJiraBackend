package com.jira.AccoliteJiraBackend.BusinessLogic;

import com.jira.AccoliteJiraBackend.Base.Credentials;
import com.jira.AccoliteJiraBackend.Base.Employee;
import com.jira.AccoliteJiraBackend.Repository.EmployeeRepository;
import com.jira.AccoliteJiraBackend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeComponent {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;


    public String checkCredentials(Credentials credentials)
    {
        Employee employee=employeeRepository.getEmployeeByEmail(credentials.getEmail());
        if(employee==null)
        {
            throw new IllegalStateException("Employee with that email not present ");
        }
        if(employee.getPassword().equals(credentials.getPassword()))
            return "Successfully Login";
        else
            throw new IllegalStateException("Password Incorrect");
    }

    public Employee findEmployeeByAlias(String alias)
    {
        return employeeRepository.getEmployeeByAlias(alias);
    }

}
