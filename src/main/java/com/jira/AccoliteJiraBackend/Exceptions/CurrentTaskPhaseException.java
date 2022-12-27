package com.jira.AccoliteJiraBackend.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class CurrentTaskPhaseException extends Exception{

    public CurrentTaskPhaseException(String message) {
        super(message);
    }
}
