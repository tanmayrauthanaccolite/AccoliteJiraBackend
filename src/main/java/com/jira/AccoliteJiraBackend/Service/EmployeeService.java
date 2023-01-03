package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Base.*;
import com.jira.AccoliteJiraBackend.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee) {

        employeeRepository.save(employee);
    }
    public Employee findEmployeeById(long employeeId) {

        return employeeRepository.findById(employeeId).get();
    }
    public List<Employee> getAllEmployeesByProjectId(long projectId){

        return employeeRepository.findByProjectsProjectId(projectId);
    }
    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }
    public List<String> getEmployeesDropDown(){

         return employeeRepository.findByAlias();
    }

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



}
