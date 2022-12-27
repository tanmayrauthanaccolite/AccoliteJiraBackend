package com.jira.AccoliteJiraBackend.Service;

import com.jira.AccoliteJiraBackend.Entity.Employee;
import com.jira.AccoliteJiraBackend.Entity.Epic;
import com.jira.AccoliteJiraBackend.JPARepository.EmployeeRepository;
import com.jira.AccoliteJiraBackend.JPARepository.EpicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    public void createEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).get();
    }
}
