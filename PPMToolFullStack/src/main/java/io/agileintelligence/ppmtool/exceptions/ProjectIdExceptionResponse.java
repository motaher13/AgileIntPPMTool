package io.agileintelligence.ppmtool.exceptions;

public class ProjectIdExceptionResponse {
    private String projectIdentifier;


    public ProjectIdExceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;  /* note: this line create the message with while exception generated 8-7.30*/
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
