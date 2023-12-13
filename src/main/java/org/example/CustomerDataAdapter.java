package org.example;

import java.nio.charset.StandardCharsets;

/**
 * Author: Bhargav Gundapaneni
 * Course: CS-665 Software Design & Patterns
 * Date: November 30, 2023
 * File Name: CustomerDataAdapter.java
 * Description: This class adapts the legacy CustomerData_USB interface to the new CustomerData_HTTPS
 *              system, allowing for interaction between the two systems.
 */
public class CustomerDataAdapter implements CustomerData_HTTPS {
    private CustomerData_USB legacySystem;

    // Constructor to initialize the legacy system
    public CustomerDataAdapter(CustomerData_USB legacySystem) {
        this.legacySystem = legacySystem;
    }

    // Implementation of the printCustomer method from CustomerData_HTTPS
    @Override
    public void printCustomer(int customerId) {
        try {
            // Forward the print request to the legacy system
            legacySystem.printCustomer(customerId);
        } catch (Exception e) {
            // Improved error handling: log or handle the error appropriately
            System.err.println("Error occurred while printing customer data: " + e.getMessage());
        }
    }

    // Implementation of the getCustomer_HTTPS method from CustomerData_HTTPS
    @Override
    public String getCustomer_HTTPS(int customerId) {
        try {
            // Retrieve customer data from the legacy system as a byte array
            byte[] customerData = legacySystem.getCustomer_USB(customerId);
            // Convert the byte array to a String and return
            return convertDataToString(customerData);
        } catch (Exception e) {
            // Improved error handling: log or handle the error appropriately
            System.err.println("Error occurred while retrieving customer data: " + e.getMessage());
            return ""; // Return an empty string or handle it according to your error policy
        }
    }

    // Private helper method for data conversion to reduce duplication
    private String convertDataToString(byte[] data) {
        // Here you can handle various data transformation logic if needed
        return new String(data, StandardCharsets.UTF_8); // Use StandardCharsets for encoding specification
    }
}
