package io.agileintelligence.ppmtool.exceptions;

public class UsernameAlreadyExistsResponse {

    private String Username;

    public UsernameAlreadyExistsResponse(String username) {
        Username = username;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
