package com.maven.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class User {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @Size(min = 6, max = 12, message = "The password should contains no more than 12 characters, and no less than 6 characters.")
    private String password;
    @Size(min = 6, max = 12, message = "The password should contains no more than 12 characters, and no less than 6 characters.")
    private String name;
    @Max(2020)
    @Min(1870)
    private int year;
    @Max(12)
    @Min(1)
    private int month;
    @Max(31)
    @Min(1)
    private int day;
    // For gender, 1 is female, 2 is male, 3 is prefer not to say
    @Max(3)
    @Min(1)
    private int gender;


    public User() {

    }

    public User (String email, String name, String password, int year, int month, int day, int gender) {
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
        this.setGender(gender);
    }


    public User (int id, String email, String name, String password, int year, int month, int day, int gender) {
        this.id = id;
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setYear(year);
        this.setMonth(month);
        this.setDay(day);
        this.setGender(gender);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*")) {
            this.email = email;
        } else {
            this.email = null;
            System.out.println("This is NOT a valid email address");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() < 5 || password.length() > 12) {
            System.out.println("The input is INVALID. The password should contains no more than 12 characters and no less than 6 characters.");
            this.password = null;
            return ;
        }
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 5 || name.length() > 12) {
            System.out.println("The input is INVALID. The password should contains no more than 12 characters and no less than 6 characters.");
            this.name = null;
            return ;
        }
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i)) && !Character.isDigit(name.charAt(i))) {
                System.out.println("This field can only contain numbers and letters. No special characters and spaces allowed.");
                this.name = null;
                return;
            }
        }
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        if (gender <= 0 || gender >= 4) {
            System.out.println("This is NOT a valid gender.");
            this.gender = -1;
            return;
        }

        this.gender = gender;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year <= 1870 || year >= 2020) {
            System.out.println("This is NOT a valid year for birthday.");
            this.year = -1;
            return;
        }
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month <= 0 || month >= 13) {
            System.out.println("This is NOT a valid month for birthday.");
            this.month = -1;
            return;
        }
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if (day <= 0 || day >= 32) {
            System.out.println("This is NOT a valid day for birthday.");
            this.day = -1;
            return;
        }

        this.day = day;
    }


    @Override
    public String toString() {
        return "JAVAStudent [ID=" + id + ", name=" + name +  ", email address="
                + email + "]";
    }
}
