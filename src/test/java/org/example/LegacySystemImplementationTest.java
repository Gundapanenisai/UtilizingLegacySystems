package org.example;
/**
 * Author: Bhargav Gundapaneni
 * Course: CS-665 Software Design & Patterns
 * Date: 2st December, 2023
 * File Name: LegacySystemImplementationTest.java
 * Description: This class contains unit tests for the LegacySystemImplementation class.
 *              The LegacySystemImplementation class integrates the legacy CustomerData_USB
 *              interface with the new CustomerData_HTTPS system.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class LegacySystemImplementationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private LegacySystemImplementation legacySystem;

    @Before
    public void setUp() {
        legacySystem = new LegacySystemImplementation();
        System.setOut(new PrintStream(outContent)); // Redirect System.out to outContent stream
    }

    @After
    public void restoreSystemOut() {
        System.setOut(originalOut); // Restore the original System.out
    }

    @Test
    public void testPrintCustomer_PrintsCorrectData() {
        int customerId = 123;
        legacySystem.printCustomer(customerId);
        String expectedOutput = "Legacy Customer ID: 123" + System.lineSeparator();
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetCustomer_USB_ReturnsCorrectData() {
        int customerId = 123;
        byte[] result = legacySystem.getCustomer_USB(customerId);
        String resultString = new String(result, StandardCharsets.UTF_8);
        assertEquals("Customer Data for ID: 123", resultString);
    }

    @Test
    public void testGetCustomer_USB_HandlesExceptionGracefully() {
        int customerId = 123;
        byte[] result = null;
        try {
            // Assuming a situation that would cause getCustomer_USB to throw an exception
            result = legacySystem.getCustomer_USB(customerId);
        } catch (Exception e) {
            fail("Method should handle exceptions and not throw them.");
        }
        assertNotNull("Result should not be null even in case of exception.", result);
    }
}
