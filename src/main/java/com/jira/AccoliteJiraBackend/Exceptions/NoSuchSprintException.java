package com.jira.AccoliteJiraBackend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NoSuchSprintException extends Exception{
        public NoSuchSprintException(String errorMessage){
            super(errorMessage);
        }
}



