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
    public String CaretakerEmail;

    public Patient(String name, String dob, String gender, String contactNum, String emailAdd, String add, String password, String caretakerEmail) {
        Name = name;
        Dob = dob;
        Gender = gender;
        ContactNum = contactNum;
        EmailAdd = emailAdd;
        Add = add;
        Password = password;
        CaretakerEmail = caretakerEmail;
    }

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
                ", CaretakerEmail='" + CaretakerEmail + '\'' +
                '}';
    }

    public Patient() {
    }


}
