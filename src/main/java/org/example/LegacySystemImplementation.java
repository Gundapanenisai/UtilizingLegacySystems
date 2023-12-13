package org.example;

import java.nio.charset.StandardCharsets;

/**
 * Author: Bhargav Gundapaneni
 * Course: CS-665 Software Design & Patterns
 * Date: November 30, 2023
 * File Name: LegacySystemImplementation.java
 * Description: This class implements the CustomerData_USB interface as a mock legacy system
 *              to demonstrate integration with the new CustomerData_HTTPS system.
 */
public class LegacySystemImplementation implements CustomerData_USB {

    // Implementation of the printCustomer method from CustomerData_USB
    @Override
    public void printCustomer(int customerId) {
        try {
            // Simulate printing customer information with the legacy system
            System.out.println("Legacy Customer ID: " + customerId);
        } catch (Exception e) {
            // Log or handle printing error
            System.err.println("Error occurred while printing legacy customer data: " + e.getMessage());
        }
    }

    // Implementation of the getCustomer_USB method from CustomerData_USB
    @Override
    public byte[] getCustomer_USB(int customerId) {
        try {
            // Mock implementation to retrieve customer data as bytes
            String customerInfo = "Customer Data for ID: " + customerId;
            // Convert the customer information to bytes (simulating legacy data retrieval)
            return customerInfo.getBytes(StandardCharsets.UTF_8);
        } catch (Exception e) {
            // Log or handle data retrieval error
            System.err.println("Error occurred while retrieving legacy customer data: " + e.getMessage());
            return new byte[0]; // Return empty array or handle it according to your error policy
        }
    }
}
