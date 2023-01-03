package com.jira.AccoliteJiraBackend.Base;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.*;


@Entity
@Getter
@Setter
@Component
@Table(name="sprints")
public class Sprint {

         @Id
         @GeneratedValue(strategy = GenerationType.AUTO)
         @Column(name="sprintid")
         private long sprintId;

         @Column(name="projectid")
         @NotNull
         private String projectId;

         @Column(name="allottedtime")
         @NotNull
         private int allottedTime;

         @NotNull
         @Column(name="sprintdescription")
         private String sprintDescription;

         @Column(name="startdate")
         @NotNull
         @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
         private Date startDate;

         @Column(name="enddate")
         @NotNull
         @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
         private Date endDate;

         @Column(name="iscurrent")
         @NotNull
         private boolean isCurrent;

         @ManyToOne
         @JoinColumn(name="projectsprintid",referencedColumnName = "projectid")
         private Project sprintOfProject;


         @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
         @JoinTable(
                  name="sprint_jira",
                  joinColumns = @JoinColumn(name="sprint_id",referencedColumnName = "sprintId"),
                  inverseJoinColumns = @JoinColumn(name="jira_id",referencedColumnName = "jiraId")
         )
         @JsonBackReference
         private List<Jira> jirasOfSprint;





}
