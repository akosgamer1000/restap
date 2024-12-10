package com.example.restapi_people;

public class People {

    private int id;
    private String FirstName;
    private String LastName;
    private int Age;
    private String Email;
    private String Phone;

    public People(int id, String firstName, String lastName, int age, String email, String phone) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        Age = age;
        Email = email;
        Phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
