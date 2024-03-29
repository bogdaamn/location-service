package com.task.locationservice.dto;

public class UserDto {

    private Long id;
    private String login;
    private String token;

    public UserDto() {
    }

    public UserDto(Long id, String login, String token) {
        this.id = id;
        this.login = login;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}