package com.example.simpletest.model;

import lombok.*;

import java.util.Date;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor;
//@ToString
public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int activeStatus;
    private Date dataDate;


    public User() {
    }

    public User(Integer id, String firstName, String lastName, String username, String password, int activeStatus, Date dataDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.activeStatus = activeStatus;
        this.dataDate = dataDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(int activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", activeStatus=" + activeStatus +
                ", dataDate=" + dataDate +
                '}';
    }
}
