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





}
