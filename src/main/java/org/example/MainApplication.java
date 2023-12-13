package org.example;

/**
 * Author: Bhargav Gundapaneni
 * Course: CS-665 Software Design & Patterns
 * Date: November 30, 2023
 * File Name: MainApplication.java
 * Description: This class is the entry point of the application. It demonstrates the integration
 *              of the legacy system with the new CustomerData_HTTPS system using an adapter.
 */
public class MainApplication {
    public static void main(String[] args) {
        // Create an instance of the legacy system (CustomerData_USB)
        CustomerData_USB legacySystem = new LegacySystemImplementation();

        // Wrap the legacy system with the adapter to use the HTTPS interface (CustomerData_HTTPS)
        CustomerData_HTTPS httpsInterface = new CustomerDataAdapter(legacySystem);

        // Create an instance of the UserInputHandler to handle console input
        UserInputHandler userInputHandler = new UserInputHandler(httpsInterface);

        // Start the user input loop
        userInputHandler.start();
    }
}
