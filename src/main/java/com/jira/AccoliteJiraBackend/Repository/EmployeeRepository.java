package com.jira.AccoliteJiraBackend.Repository;

import com.jira.AccoliteJiraBackend.Base.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
      List<Employee> findByProjectsProjectId(@Param("projectid") long projectId);
      @Query(value = "SELECT alias FROM Employee",nativeQuery = true)
      List<String> findByAlias();

      @Query("select e from Employee e where e.email=:email")
      Employee getEmployeeByEmail(@Param("email") String email);

      @Query("select e from Employee e where e.alias=:alias")
      Employee getEmployeeByAlias(@Param("alias") String alias);

      @Query(value = "select employeeid from employee e where e.alias = :alias ",nativeQuery = true)
      long getByAlias(@Param("alias") String alias);
}
