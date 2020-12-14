package com.jie.mybatis.bean;

/**
 * Employee
 *
 * @author Jie
 * @description
 * @create 2020/12/15 01:35
 */
public class Employee {
    private Integer id;
    private String gender;
    private String email;
    private String lastName;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
