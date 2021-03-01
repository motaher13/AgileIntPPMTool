package io.agileintelligence.ppmtool.exceptions;

public class ProjectNotFoundExceptionResponse {
    private String projectNotFound;


    public ProjectNotFoundExceptionResponse(String projectNotFound) {
        this.projectNotFound = projectNotFound;  /* note: this line create the message with while exception generated 8-7.30*/
    }

    public String getProjectNotFound() {
        return projectNotFound;
    }

    public void setProjectNotFound(String projectNotFound) {
        this.projectNotFound = projectNotFound;
    }
}
