package com.jira.AccoliteJiraBackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
//@Getter
//@Setter
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectid;

    @Column(name = "projectDescription",nullable=true)
    private String projectDescription;

    @Column(name = "projectLabel",nullable=true)
    private String projectLabel;

    @CreationTimestamp
    private Timestamp timestamp;

    @Column(name = "isActive",nullable=false)
    private boolean isActive;

    @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Epic> epics=new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Employees_Projects",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "employee_id") }
    )
    //@JsonManagedReference
    private Set<Employee> employees = new HashSet<>();

    public long getProjectid() {
        return projectid;
    }

    public void setProjectid(long projectid) {
        this.projectid = projectid;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setProjectLabel(String projectLabel) {
        this.projectLabel = projectLabel;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectLabel() {
        return projectLabel;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public boolean isActive() {
        return isActive;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Epic> getEpics() {
        return epics;
    }

    public void setEpics(Set<Epic> epics) {
        this.epics = epics;
    }
}
