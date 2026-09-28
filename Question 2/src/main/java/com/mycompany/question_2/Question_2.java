/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.question_2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Question_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



// Interface defining console operations
interface IConsole {
    String getConsoleType();
    String getStoreName();
    int getSales();
}

// Abstract class implementing IConsole
abstract class Console implements IConsole {
    private String consoleType;
    private String storeName;
    private int sales;

    // Constructor
    public Console(String consoleType, String storeName, int sales) {
        this.consoleType = consoleType;
        this.storeName = storeName;
        this.sales = sales;
    }

    // Getter methods
    @Override
    public String getConsoleType() {
        return consoleType;
    }

    @Override
    public String getStoreName() {
        return storeName;
    }

    @Override
    public int getSales() {
        return sales;
    }
}

// Subclass extending Console
class ConsoleSales extends Console {
    public ConsoleSales(String consoleType, String storeName, int sales) {
        super(consoleType, storeName, sales);
    }
}

// Main application runner
public class RunApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] consoleTypes = {"Xbox", "PS5", "Switch"};

    
        int storeCount = readPositiveInt(scanner, "Enter number of stores to record: ");

        ConsoleSales[] storeData = new ConsoleSales[storeCount];

        // Record store sales
        for (int i = 0; i < storeCount; i++) {
            System.out.println("\nStore #" + (i + 1));

            // List console types
            System.out.println("Select console type:");
            for (int j = 0; j < consoleTypes.length; j++) {
                System.out.println((j + 1) + ". " + consoleTypes[j]);
            }
            int choice = readChoice(scanner, 1, consoleTypes.length);
            String selectedConsole = consoleTypes[choice - 1];

            // Store name
            System.out.print("Enter store: ");
            String storeName = scanner.nextLine().trim();

            // Sales
            int sales = readPositiveInt(scanner, "Enter total sales for" + storeName + ": ");

            // Create ConsoleSales object
            storeData[i] = new ConsoleSales(selectedConsole, storeName, sales);
        }

        // Display report
        System.out.println("\n=== Sales Report ===");
        for (ConsoleSales cs : storeData) {
            System.out.println("Store: " + cs.getStoreName() +
                               " | Console: " + cs.getConsoleType() +
                               " | Sales: " + cs.getSales());
        }

        scanner.close();
    }

    // Reads a valid menu choice
    private static int readChoice(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Enter choice (" + min + "-" + max + "): ");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= min && choice <= max) {
                    return choice;
                }
                System.out.println("Please enter a number between " + min + " and " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Reads a positive integer
    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("Please enter a non-negative number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

