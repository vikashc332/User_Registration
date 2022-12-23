package com.blz.useregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Useregistration {
    Scanner scanner = new Scanner(System.in);
    UserDetails userDetails = new UserDetails();

    public void addUser() {
        int choice = 0;
        do {
            System.out.println("1. First Name\n0. Exit");
            System.out.println("Enter choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String firstName = stringInput("Enter First Name");
                    addFirstName(firstName);
                    break;
            }
        } while (choice != 0);
    }

    private String stringInput(String msg) {
        System.out.println(msg);
        String strData = scanner.next();
        return strData;
    }

    public boolean addFirstName(String firstName) {
        boolean isFirstName = Pattern.matches(UserDetailsRegexPattern.FIRST_NAME, firstName);
        if (isFirstName) {
            userDetails.setFirstName(firstName);
            return true;
        } else {
            System.out.println("Please check First Name");
            return false;
        }
    }
}

