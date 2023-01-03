package com.jira.AccoliteJiraBackend.Controller;

import com.jira.AccoliteJiraBackend.Base.Employee;
import com.jira.AccoliteJiraBackend.Base.Credentials;
import com.jira.AccoliteJiraBackend.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/getallemployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
           try{
               return new ResponseEntity<List<Employee>>(employeeService.getAllEmployees(),HttpStatus.OK);
           } catch (Exception e){
               return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
           }
    }

    @GetMapping("/getemployeedropdown")
    public ResponseEntity<List<String>> getEmployeesDropDown(){
        return new ResponseEntity<>(employeeService.getEmployeesDropDown(),HttpStatus.OK);
    }

    @GetMapping("/getemployee/{employeeId}")
    public Employee findEmployeeById(@PathVariable("employeeId") long employeeId){
           return employeeService.findEmployeeById(employeeId);
    }

    @GetMapping("/projectemployees/{projectId}/allemployees")
    public ResponseEntity<List<Employee>> getAllEmployeesByProjectId(@PathVariable("projectId") Long projectId){
         try{
             return new ResponseEntity<List<Employee>>(employeeService.getAllEmployeesByProjectId(projectId),HttpStatus.OK);
         } catch (Exception e){
              return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        try {
            employeeService.createEmployee(employee);
            return new ResponseEntity<>(employee, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/checkcredentials")
    public String checkCredentials(@RequestBody Credentials credentials)
    {
        System.out.println(credentials.getEmail());
        System.out.println(employeeService.checkCredentials(credentials));
        return employeeService.checkCredentials(credentials);
    }



}
