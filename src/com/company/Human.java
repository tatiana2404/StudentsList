package com.company;

import java.io.Serializable;

public class Human implements Serializable {

    private String surname;
    private String name;
    private int age;
    Sex gender;
    public Human(){}
    public  Human(String surname, String name, int age, Sex gender){
        this.surname=surname;
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return  "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age+" ";
    }
}
