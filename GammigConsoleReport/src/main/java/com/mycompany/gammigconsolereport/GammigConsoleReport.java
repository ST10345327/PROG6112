/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gammigconsolereport;

/**
 *
 * @author Student
 */

public class GammigConsoleReport {
    public static void main(String[] args) {
        // 1D arrays for cities and consoles
        String[] cities = {"CAPE TOWN", "PORT ELIZABETH", "PRETORIA"};
        String[] consoles = {"PS5", "XBOX", "SWITCH"};

        // 2D array for sales [city][console] using int
        int[][] sales = {
            {1000, 2000, 3000},  // Cape Town
            {2000, 3000, 4000}, // Port Elizabeth
            {1500, 1100, 1200}   // Pretoria
        };

        // Display main sales table (no totals)
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("GAMING CONSOLE REPORT ");
        System.out.println("------------------------------------------------------------------------------");
        System.out.printf("%-15s", " ");
        for (String console : consoles) {
            System.out.printf("%-15s", console);
        }
        System.out.println();

        for (int i = 0; i < cities.length; i++) {
            System.out.printf("%-15s", cities[i]);
            for (int j = 0; j < consoles.length; j++) {
                System.out.printf("%-15d", sales[i][j]);
            }
            System.out.println();
        }

        // totals section
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("\nCONSOLE SALES TOTAL FOR EACH CITY");
        System.out.println("------------------------------------------------------------------------------");
        int maxSales = Integer.MIN_VALUE;
        String topCity = "";

        for (int i = 0; i < cities.length; i++) {
            int cityTotal = 0;
            for (int j = 0; j < consoles.length; j++) {
                cityTotal += sales[i][j];
            }
            System.out.printf("%-15s  %d%n", cities[i], cityTotal);

            // Track city with most sales
            if (cityTotal > maxSales) {
                maxSales = cityTotal;
                topCity = cities[i];
            }
        }

        // Display city with most sales
        System.out.println("\nCITY WITH THE MOST SALES: " + topCity);
        System.out.println("------------------------------------------------------------------------------");
    }
}

