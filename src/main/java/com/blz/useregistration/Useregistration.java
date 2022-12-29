package com.blz.useregistration;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Useregistration {
    Scanner scanner = new Scanner(System.in);
    UserDetails userDetails = new UserDetails();

    public void addUser() throws UserDetailException {
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

    public boolean addFirstName(String firstName) throws UserDetailException {
        try {
            if (firstName.length() == 0) {
                throw new UserDetailException("Please enter valid first name", UserDetailException.ExceptionTypes.ENTERED_EMPTY);
            }
            boolean isFirstName = Pattern.matches(UserDetailsRegexPattern.FIRST_NAME_LAST_NAME, firstName);
            if (isFirstName) {
                userDetails.setFirstName(firstName);
                return true;
            }
        } catch (NullPointerException e) {
            throw new UserDetailException("Please enter valid first name", UserDetailException.ExceptionTypes.ENTERED_NULL);
        }
        System.out.println("Please check First Name");
        return false;
    }

    public boolean addLastName(String lastName) throws UserDetailException {
        try {
            if (lastName.length() == 0) {
                throw new UserDetailException("Please enter valid last name", UserDetailException.ExceptionTypes.ENTERED_EMPTY);
            }
            boolean isLastName = Pattern.matches(UserDetailsRegexPattern.FIRST_NAME_LAST_NAME, lastName);
            if (isLastName) {
                userDetails.setLastName(lastName);
                return true;
            }
        } catch (NullPointerException e) {
            throw new UserDetailException("Please enter valid last name", UserDetailException.ExceptionTypes.ENTERED_NULL);
        }
        System.out.println("Please check Last Name");
        return false;
    }

    public boolean addEmail(String email) throws UserDetailException {
        try {
            if (email.length() == 0) {
                throw new UserDetailException("Please enter valid Email", UserDetailException.ExceptionTypes.ENTERED_EMPTY);
            }
            boolean isMailId = Pattern.matches(UserDetailsRegexPattern.EMAIL, email);
            if (isMailId) {
                userDetails.setEmail(email);
                return true;
            }
        } catch (NullPointerException e) {
            throw new UserDetailException("Please enter valid Email", UserDetailException.ExceptionTypes.ENTERED_NULL);
        }
        System.out.println("Please check email id");
        return false;
    }

    public boolean addPhoneNumber(String phoneNumber) throws UserDetailException {
        try {
            if (phoneNumber.length() == 0) {
                throw new UserDetailException("Please enter valid Phone number", UserDetailException.ExceptionTypes.ENTERED_EMPTY);
            }
            boolean isPhoneNumber = Pattern.matches(UserDetailsRegexPattern.PHONE_NUMBER, phoneNumber);
            if (isPhoneNumber) {
                userDetails.setPhoneNumber(phoneNumber);
                return true;
            }
        } catch (NullPointerException e) {
            throw new UserDetailException("Please enter valid Phone number", UserDetailException.ExceptionTypes.ENTERED_NULL);
        }
        System.out.println("Please check Phone Number");
        return false;
    }

    public boolean addPassword(String password) throws UserDetailException {
        try {
            if (password.length() == 0) {
                throw new UserDetailException("Please enter valid Phone number", UserDetailException.ExceptionTypes.ENTERED_EMPTY);
            }
            boolean isPassword = Pattern.matches(UserDetailsRegexPattern.PASSWORD, password);
            if (isPassword) {
                userDetails.setPassword(password);
                return true;
            } else {
                System.out.println("Please check Password");
                return false;
            }
        }catch (NullPointerException e){
            throw new UserDetailException("Please enter valid Phone number", UserDetailException.ExceptionTypes.ENTERED_NULL);
        }
    }

    public <E> void validateInput(E input) throws UserDetailException {
        if (input.toString().length() == 0) {
            throw new UserDetailException("Please enter valid input", UserDetailException.types.ENTERED_EMPTY);
        }
        if (input.toString() == null) {
            throw new UserDetailException("Please enter valid input", UserDetailException.types.ENTERED_NULL);
        }
    }

}

