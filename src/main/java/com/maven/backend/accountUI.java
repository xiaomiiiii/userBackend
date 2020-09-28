package com.maven.backend;

import java.util.Scanner;

public class accountUI {
    public static User userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter you email address");
        String email = sc.nextLine();
        System.out.println("Please enter you name");
        String name = sc.nextLine();
        System.out.println("Please enter you password");
        String password = sc.nextLine();
        System.out.println("Please enter the year of your birthday");
        int year = Integer.valueOf(sc.nextLine());
        System.out.println("Please enter the month of your birthday");
        int month = Integer.valueOf(sc.nextLine());
        System.out.println("Please enter the day of your birthday");
        int day = Integer.valueOf(sc.nextLine());
        System.out.println("Please enter your gender. 1 is female, 2 is male, 3 is prefer not to say");
        int gender = Integer.valueOf(sc.nextLine());

        User user = new User(email, name, password, year, month, day, gender);

        return user;
    }
}
