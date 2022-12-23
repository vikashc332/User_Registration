package com.blz.useregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Useregistration {
    Scanner scanner = new Scanner(System.in);
    UserDetails userDetails = new UserDetails();

    public void addUser() {
        int choice = 0;
        do {
            System.out.println("1. First Name\n2. Last Name\n3. Email\n4. Phone Number\n5. Password\n0. Exit");
            System.out.println("Enter choice");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    String firstName = stringInput("Enter First Name");
                    addFirstName(firstName);
                    break;
                case 2:
                    String lastName = stringInput("Enter Last Name");
                    addLastName(lastName);
                    break;
                case 3:
                    String email = stringInput("Enter email");
                    addEmail(email);
                    break;
                case 4:
                    String phoneNumber = stringInput("Enter phone number");
                    addPhoneNumber(phoneNumber);
                    break;
                case 5:
                    String password = stringInput("Enter Password");
                    addPassword(password);
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
    public boolean addLastName(String lastName) {
        boolean isLastName = Pattern.matches(UserDetailsRegexPattern.FIRST_NAME_LAST_NAME, lastName);
        if (isLastName) {
            userDetails.setLastName(lastName);
            return true;
        } else {
            System.out.println("Please check Last Name");
            return false;
        }
    }
    public boolean addEmail(String email) {
        boolean isMailId = Pattern.matches(UserDetailsRegexPattern.EMAIL, email);
        if (isMailId) {
            userDetails.setEmail(email);
            return true;
        } else {
            System.out.println("Please check email id");
            return false;
        }
    }
    public boolean addPhoneNumber(String phoneNumber) {
        boolean isPhoneNumber = Pattern.matches(UserDetailsRegexPattern.PHONE_NUMBER, phoneNumber);
        if (isPhoneNumber) {
            userDetails.setPhoneNumber(phoneNumber);
            return true;
        } else {
            System.out.println("Please check Phone Number");
            return false;
        }
    }

    public boolean addPassword(String password) {
        boolean isPassword = Pattern.matches(UserDetailsRegexPattern.PASSWORD, password);
        if (isPassword) {
            userDetails.setPassword(password);
            return true;
        } else {
            System.out.println("Please check Password");
            return false;
        }
    }
}

