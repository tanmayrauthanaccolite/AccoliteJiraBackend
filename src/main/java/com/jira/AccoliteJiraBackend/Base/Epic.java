package com.jira.AccoliteJiraBackend.Base;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.List;



@Entity
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Component
@Table(name = "epic")
public class Epic {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="epicid")
    private long epicId;

    @NotNull
    @Column(name = "epiclabel")
    private String epicLabel;

    @NotNull
    @Column(name = "epicdescription")
    private String epicDescription;

    @Column(name = "assignee",nullable = false)
    private String assignee;

    @NotNull
    @Column(name = "priority")
    private long priority;

    @NotNull
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name="epic_projectid",referencedColumnName = "projectid")
    private Project project;

    @OneToMany(mappedBy = "taskOfEpic")
    @JsonManagedReference
    private List<Tasks> tasks ;

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

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}

