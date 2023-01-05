package com.jira.AccoliteJiraBackend.Base;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@Entity
@Table(name="jira")
public class Jira {

         @Id
         @NotNull
         @GeneratedValue(strategy = GenerationType.IDENTITY)
         private long jiraId;

         @Column(name="projectname")
         @NotNull
         private String projectName;

         @Column(name="jirastatus")
         @NotNull
         private String jiraStatus;

         @Column(name="jiratitle")
         @NotNull
         private String jiraTitle;

         @Column(name="jiradescription")
         @NotNull
         private String jiraDescription;

         @Column(name="jiraassignee")
         @NotNull
         private String jiraAssignee;

         @Column(name="jirareporter")
         @NotNull
         private String jiraReporter;

         @Column(name="jiratype")
         @NotNull
         private String jiraType;

         @Column(name="jirasprint")
         @NotNull
         private String jiraSprint;

//    for the flag checks for main functionalities
         @OneToOne(mappedBy="jirastate")
         private Checks checks;

         @ManyToOne
         @JoinColumn(name="epictasksid", referencedColumnName = "jiraid")
         private Jira jiraepic;

         @OneToMany(mappedBy = "jiraepic",fetch = FetchType.EAGER)
         @JsonIgnore
         private List<Jira> JiraTasks;

         @ManyToOne
         @JoinColumn(name="jiraproject_id", referencedColumnName = "projectid")
         private Project jiraprojects;

         @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "jirasOfSprint")
         private List<Sprint> sprintOfJiras;



}
