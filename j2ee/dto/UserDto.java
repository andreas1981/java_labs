package com.kuzmenko.dto;

/**
 * Created by Kovantonlenko on 6/16/2016.
 */
public class UserDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getSecondName() + " " + this.getAge();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
