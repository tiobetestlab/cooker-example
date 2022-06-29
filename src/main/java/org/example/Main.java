// Copyright (c) TIOBE Software 2022

package org.example;

/**
 * Main function of the cooker plate.
 */
public class Main {
    public static void main(String[] args) {

        final CookerPlate cookerPlate = new CookerPlate();
        cookerPlate.heat();
        System.out.println("Temperature at the moment is "+cookerPlate.Temperature()+".");

    }
}