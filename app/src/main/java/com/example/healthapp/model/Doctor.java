package com.example.healthapp.model;

public class Doctor {
    public String Name;
    public String Email;
    public String pass;
    public String contact;
    public String specialization;
    public String qualification;

    public Doctor(String name, String email, String pass, String contact, String specialization, String qualification) {
        Name = name;
        Email = email;
        this.pass = pass;
        this.contact = contact;
        this.specialization = specialization;
        this.qualification = qualification;
    }

    public Doctor() {

    }

    @Override
    public String toString() {
        return "Doctor{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", pass='" + pass + '\'' +
                ", contact='" + contact + '\'' +
                ", specialization='" + specialization + '\'' +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
