package com.jira.AccoliteJiraBackend.Controller;

public final class PathConstants {

    private PathConstants() {
        throw new AssertionError("No instances for you!");
    }

    public static final String getAllEmpPath = "/employees/getallemployees";
    public static final String getEmpDropDownPath = "/employees/getemployeedropdown";
    public static final String findEmpByIdPath = "/employees/getemployee/{employeeId}";
    public static final String getEmpByProjectPath = "/employees/projectemployees/{projectId}/allemployees";
    public static final String addEmpPath = "/employees/employee";
    public static final String deleteEmpPath = "/employees/delete/{employeeId}";

    public static final String getAllJirasPath ="/jira/alljiras";
    public static final String getProjectIdPath = "/jira/jiraprojectid/{projectLabel}";
    public static final String getJiraPath = "/jira/jirabyid/{jiraId}";
    public static final String addJiraPath ="/jira/addjira";
    public static final String updateJiraPath ="/jira/updateJira/{jiraId}";
    public static final String deleteJiraPath ="/jira/deletejira/{jiraId}";

    public static final String viewAllProjectPath ="/projects/viewProject";
    public static final String viewProjectByIdPath ="/projects/viewProjectbyId/{projectId}";
    public static final String getProjectDropDownPath ="/projects/projectdropdown";
    public static final String addProjectPath ="/projects/project";
    public static final String addEmpProjectPath ="/projects/add/employee/{projectId}/project/{employeeId}";
    public static final String deleteProjectPath ="/projects/remove/employee/{projectId}/project/{employeeId}";

    public static final String addSprintPath ="/sprint/addSprint";
    public static final String viewAllSprintPath ="/sprint/viewSprint";
    public static final String viewSprintPath ="/sprint/{sprintId}";
    public static final String viewCurrentSprintPath ="/sprint/currentsprint/{projectId}";
    public static final String addJiraSprintPath ="/sprint/{sprintId}/jiras/{jiraId}";
    public static final String addSprintProjectPath ="/sprint/{sprintId}/projects/{projectId}";
}
