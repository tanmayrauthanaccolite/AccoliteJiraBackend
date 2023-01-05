package com.jira.AccoliteJiraBackend.Base;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SprintUpdate {

       private int sprintTime;
       private Date sprintStartDate;
       private Date sprintEndDate;
}
