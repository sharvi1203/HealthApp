package com.example.healthapp.model;

public class Caretaker {
    public String Name;
    public String Gender;
    public String ContactNum;
    public String Pass;
    public String EmailAdd;
    public String Add;

    public Caretaker(String name, String gender, String contactNum, String pass, String emailAdd, String add) {
        Name = name;
        Gender = gender;
        ContactNum = contactNum;
        Pass = pass;
        EmailAdd = emailAdd;
        Add = add;
    }

    public Caretaker() {

    }

    @Override
    public String toString() {
        return "Caretaker{" +
                "Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", ContactNum='" + ContactNum + '\'' +
                ", Pass='" + Pass + '\'' +
                ", EmailAdd='" + EmailAdd + '\'' +
                ", Add='" + Add + '\'' +
                '}';
    }
}
