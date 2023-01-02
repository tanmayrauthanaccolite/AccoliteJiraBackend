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


}

