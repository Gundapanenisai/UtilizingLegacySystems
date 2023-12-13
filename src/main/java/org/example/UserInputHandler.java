package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Author: Bhargav Gundapaneni
 * Course: CS-665 Software Design & Patterns
 * Date: November 30, 2023
 * File Name: UserInputHandler.java
 * Description: This class handles user input and provides a menu for interacting with
 *              the CustomerData_HTTPS system.
 */

public class UserInputHandler {
    private final CustomerData_HTTPS customerData;

    public UserInputHandler(CustomerData_HTTPS customerData) {
        this.customerData = customerData;
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            int option = -1; // Initialize the variable

            do {
                displayMenu();
                try {
                    option = getUserOption(scanner);
                    processOption(scanner, option);
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numeric values only.");
                    scanner.nextLine(); // Clear the incorrect input
                    option = -1; // Reset the option
                }
            } while (option != 0);
        }
    }


    private void displayMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1. Print Customer Data");
        System.out.println("2. Get Customer Data");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserOption(Scanner scanner) throws InputMismatchException {
        return scanner.nextInt();
    }

    private void processOption(Scanner scanner, int option) {
        switch (option) {
            case 1:
                handlePrintCustomer(scanner);
                break;
            case 2:
                handleGetCustomer(scanner);
                break;
            case 0:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void handlePrintCustomer(Scanner scanner) {
        int idPrint = getCustomerIdFromUser(scanner);
        customerData.printCustomer(idPrint);
    }

    private void handleGetCustomer(Scanner scanner) {
        int idGet = getCustomerIdFromUser(scanner);
        System.out.println(customerData.getCustomer_HTTPS(idGet));
    }

    private int getCustomerIdFromUser(Scanner scanner) {
        System.out.print("Enter Customer ID: ");
        while (!scanner.hasNextInt()) {
            scanner.next(); // Consume the invalid input
            System.out.print("Please enter a valid numeric Customer ID: ");
        }
        return scanner.nextInt();
    }
}
