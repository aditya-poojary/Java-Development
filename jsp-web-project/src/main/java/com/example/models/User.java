package com.example.models;

public class User {
    private String username;
    private String email;
    private int age;
    private String country;

    public User() {
    }

    public User(String username, String email, int age, String country) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
