package com.example.healthapp;

import java.io.Serializable;

public class Patient implements Serializable {
    public String Name;
    public String Dob;
    public String Gender;
    public String ContactNum;
    public String EmailAdd;
    public String Add;
    public String Password;

    @Override
    public String toString() {
        return "Patient{" +
                "Name='" + Name + '\'' +
                ", Dob='" + Dob + '\'' +
                ", Gender='" + Gender + '\'' +
                ", ContactNum='" + ContactNum + '\'' +
                ", EmailAdd='" + EmailAdd + '\'' +
                ", Add='" + Add + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public Patient(String name, String dob, String gender, String contactNum, String emailAdd, String add, String password) {
        Name = name;
        Dob = dob;
        Gender = gender;
        ContactNum = contactNum;
        EmailAdd = emailAdd;
        Add = add;
        Password = password;
    }

    public Patient() {
    }


}
