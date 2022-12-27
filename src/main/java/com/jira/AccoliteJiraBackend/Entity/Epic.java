package com.jira.AccoliteJiraBackend.Entity;

import lombok.Data;

import javax.persistence.*;

//@Data
@Entity
@Table(name = "Epic")
public class Epic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long epicId;

    @Column(name = "epicLabel",nullable=false)
    private String epicLabel;

    @Column(name = "epicDescription",nullable=false)
    private String epicDescription;

    @Column(name = "assignee",nullable=false)
    private String assignee;

    @Column(name = "priority",nullable=false)
    private long priority;

    @Column(name = "status",nullable=false)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="projectid",referencedColumnName = "projectid",nullable = true)
    private Project project;

    public long getEpicId() {
        return epicId;
    }

    public void setEpicId(long epicId) {
        this.epicId = epicId;
    }

    public String getEpicLabel() {
        return epicLabel;
    }

    public void setEpicLabel(String epicLabel) {
        this.epicLabel = epicLabel;
    }

    public String getEpicDescription() {
        return epicDescription;
    }

    public void setEpicDescription(String epicDescription) {
        this.epicDescription = epicDescription;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
