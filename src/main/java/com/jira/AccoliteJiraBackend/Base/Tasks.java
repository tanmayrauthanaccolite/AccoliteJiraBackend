package com.jira.AccoliteJiraBackend.Base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tasks")
public class Tasks {


            @Id
            @Column(name="taskid",unique = true)
            @NotNull
            //the primary key of this table
            //should tasks have an auto generated sequential id or user defined id
            private int taskId;

            //private int sprintId;

            @Column(name="tasktitle")
            @NotNull
            private String taskTitle;
            @Column(name="taskassignee")
            @NotNull
            private String taskAssignee;
            @Column(name="taskreportee")
            @NotNull
            private String taskReportee;
            @Column(name="tasktype")
            @NotNull
            private String taskType;
            @Column(name="taskphase")
            @NotNull
            private String taskPhase;
            @Column(name="taskpriority")
            @NotNull
            private int taskPriority;
            @Column(name="taskpoints")
            @NotNull
            private int taskPoints;

            @Column(name="descriptiongoal")
            private String descriptionGoal;

            @Column(name="descriptionaction")
            private String descriptionAction;

            @Column(name="descriptionresult")
            private String descriptionResult;

            @JsonIgnore
            @ManyToMany(mappedBy = "sprinttasks")
            private Set<Sprint> sprints = new HashSet<>();

    public Tasks() {
    }


    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskReportee() {
        return taskReportee;
    }

    public void setTaskReportee(String taskReportee) {
        this.taskReportee = taskReportee;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskPhase() {
        return taskPhase;
    }

    public void setTaskPhase(String taskPhase) {
        this.taskPhase = taskPhase;
    }

    public int getTaskPriority() {
        return taskPriority;
    }

    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }

    public int getTaskPoints() {
        return taskPoints;
    }

    public void setTaskPoints(int taskPoints) {
        this.taskPoints = taskPoints;
    }

    public String getDescriptionGoal() {
        return descriptionGoal;
    }

    public void setDescriptionGoal(String descriptionGoal) {
        this.descriptionGoal = descriptionGoal;
    }

    public String getDescriptionAction() {
        return descriptionAction;
    }

    public void setDescriptionAction(String descriptionAction) {
        this.descriptionAction = descriptionAction;
    }

    public String getDescriptionResult() {
        return descriptionResult;
    }

    public void setDescriptionResult(String descriptionResult) {
        this.descriptionResult = descriptionResult;
    }

    public Set<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(Set<Sprint> sprints) {
        this.sprints = sprints;
    }

    public Tasks(int taskId, String taskTitle, String taskAssignee, String taskReportee, String taskType, String taskPhase, int taskPriority, int taskPoints, String descriptionGoal, String descriptionAction, String descriptionResult) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.taskAssignee = taskAssignee;
        this.taskReportee = taskReportee;
        this.taskType = taskType;
        this.taskPhase = taskPhase;
        this.taskPriority = taskPriority;
        this.taskPoints = taskPoints;
        this.descriptionGoal = descriptionGoal;
        this.descriptionAction = descriptionAction;
        this.descriptionResult = descriptionResult;
    }
}
