package org.example;
/**
 * Author: Bhargav Gundapaneni
 * Course: CS-665 Software Design & Patterns
 * Date: 2st December, 2023
 * File Name: LegacySystemImplementationTest.java
 * Description: This class contains unit tests for the  class.UserInputHandlerTest
 *              The UserInputHandlerTest class integrates the legacy CustomerData_USB
 *              interface with the new CustomerData_HTTPS system.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class UserInputHandlerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private CustomerData_HTTPS mockCustomerData;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        mockCustomerData = mock(CustomerData_HTTPS.class);
    }

    @After
    public void restore() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintCustomerOption() {
        String input = "1\n12\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInputHandler handler = new UserInputHandler(mockCustomerData);
        handler.start();

        verify(mockCustomerData, times(1)).printCustomer(12);
        assertTrue(outContent.toString().contains("Enter Customer ID:"));
    }

    @Test
    public void testGetCustomerOption() {
        String input = "2\n34\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInputHandler handler = new UserInputHandler(mockCustomerData);
        handler.start();

        verify(mockCustomerData, times(1)).getCustomer_HTTPS(34);
        assertTrue(outContent.toString().contains("Enter Customer ID:"));
    }

    @Test
    public void testInvalidOption() {
        String input = "3\n0\n"; // 3 is an invalid option based on the provided menu
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInputHandler handler = new UserInputHandler(mockCustomerData);
        handler.start();

        assertTrue(outContent.toString().contains("Invalid option. Please try again."));
    }

    @Test
    public void testExitOption() {
        String input = "0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        UserInputHandler handler = new UserInputHandler(mockCustomerData);
        handler.start();

        assertTrue(outContent.toString().contains("Exiting..."));
    }
}
