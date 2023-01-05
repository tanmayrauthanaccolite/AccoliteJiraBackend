package com.jira.AccoliteJiraBackend.Base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="checks")
public class Checks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int flagId;

    @Column(name="flag")
    private int flag;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jira_id", referencedColumnName = "jiraid")
    private Jira jirastate;
}
