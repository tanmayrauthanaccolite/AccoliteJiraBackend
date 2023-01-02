package com.jira.AccoliteJiraBackend.Base;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Component
@Table(name="tasks")
public class Tasks {


            @Id
            @Column(name="taskid",unique = true)
            @NotNull
            private int taskId;

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

            @NotNull
            @Column(name="descriptiongoal")
            private String descriptionGoal;

            @NotNull
            @Column(name="descriptionaction")
            private String descriptionAction;

            @NotNull
            @Column(name="descriptionresult")
            private String descriptionResult;

            @ManyToOne
            @JoinColumn(name="epicid",referencedColumnName ="epicid")
            @JsonBackReference
            private Epic taskOfEpic;

            @JsonIgnore
            @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "sprinttasks")
            private Set<Sprint> sprints = new HashSet<>();

}
