package com.jira.AccoliteJiraBackend.Base;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="sprints")
public class Sprint {

         //sprintId is the primary key of this table
         //should generate a sprintId with a key-prefix
         @Id
         @Column(name="sprintid",unique = true)
         @NotNull
         private int sprintId;
         @Column(name="projectid")
         @NotNull
         private String projectId;
         @Column(name="allottedtime")
         @NotNull
         private int allottedTime;
         @Column(name="sprintdescription")
         private String sprintDescription;
         @Column(name="startdate")
         @NotNull
//       @DateTimeFormat(pattern = "yyyy-MM-dd")
//       @Temporal(TemporalType.DATE)
         @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
         private Date startDate;
         @Column(name="enddate")
         @NotNull
//       @DateTimeFormat(pattern = "yyyy-MM-dd")
//       @Temporal(TemporalType.DATE)
         @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
         private Date endDate;

         @ManyToMany
         @JoinTable(
                  name="sprint_task",
                  joinColumns = @JoinColumn(name="sprint_id",referencedColumnName = "sprintId"),
                  inverseJoinColumns = @JoinColumn(name="task_id",referencedColumnName = "taskId")
         )
         private Set<Tasks> sprinttasks = new HashSet<>();

    public Sprint() {
    }

    public int getSprintId() {
        return sprintId;
    }

    public void setSprintId(int sprintId) {
        this.sprintId = sprintId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public int getAllottedTime() {
        return allottedTime;
    }

    public void setAllottedTime(int allottedTime) {
        this.allottedTime = allottedTime;
    }

    public String getSprintDescription() {
        return sprintDescription;
    }

    public void setSprintDescription(String sprintDescription) {
        this.sprintDescription = sprintDescription;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Tasks> getSprinttasks() {
        return sprinttasks;
    }

    public void setSprinttasks(Set<Tasks> sprinttasks) {
        this.sprinttasks = sprinttasks;
    }

    public Sprint(int sprintId, String projectId, int allottedTime, String sprintDescription, Date startDate, Date endDate) {
        this.sprintId = sprintId;
        this.projectId = projectId;
        this.allottedTime = allottedTime;
        this.sprintDescription = sprintDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
