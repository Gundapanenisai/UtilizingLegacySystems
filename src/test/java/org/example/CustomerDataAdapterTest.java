package org.example;


/**
 * Name: Bhargav Gundapaneni
 *
 * Course: CS-665 Software Designs & Patterns
 *
 * Date: 1st December, 2023
 *
 * File Name: CustomerDataAdapterTest.java
 *
 * Description: Unit tests for the CustomerDataAdapter class which integrates the legacy
 * CustomerData_USB interface with the new CustomerData_HTTPS system.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDataAdapterTest {
    private CustomerData_USB mockLegacySystem;
    private CustomerDataAdapter adapter;

    @Before
    public void setUp() {
        // Create a mock instance of the legacy system
        mockLegacySystem = mock(CustomerData_USB.class);
        // Create an instance of the adapter, passing the mock legacy system as a dependency
        adapter = new CustomerDataAdapter(mockLegacySystem);
    }

    @Test
    public void testPrintCustomer_ForwardsCallToLegacySystem() {
        int customerId = 123;
        // Perform the action to be tested
        adapter.printCustomer(customerId);
        // Verify that the printCustomer method was called on the mock legacy system
        verify(mockLegacySystem).printCustomer(customerId);
    }

    @Test
    public void testGetCustomer_HTTPS_WhenExceptionThrown() {
        int customerId = 123;
        when(mockLegacySystem.getCustomer_USB(customerId)).thenThrow(new RuntimeException("Failed to retrieve data"));

        // Call the method which is expected to handle the exception
        String result = adapter.getCustomer_HTTPS(customerId);

        // Verify that the result is an empty string, as the method handles the exception
        assertEquals("", result);
    }

    @Test
    public void testGetCustomer_HTTPS_HandlesException() {
        int customerId = 123;
        // Configure the mock to throw an exception
        when(mockLegacySystem.getCustomer_USB(customerId)).thenThrow(new RuntimeException("Failed to retrieve data"));
        // Perform the action to be tested
        String actualData = adapter.getCustomer_HTTPS(customerId);
        // Assert that the actual data is an empty string, as specified in the catch block
        assertTrue(actualData.isEmpty());
    }
}
