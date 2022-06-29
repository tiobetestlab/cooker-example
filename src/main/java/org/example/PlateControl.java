// Copyright (c) TIOBE Software 2022

package org.example;

/**
 * Control unit of the cooker plate.
 * Receiving temperaturecontrol as +100 or -100
 * Provides temperature as number
 */
public class PlateControl implements PlateControlInterface {

    private int TemperaturePrivate = 0;

    public int getTemperature() {
        return TemperaturePrivate;
    }

    public void changeTemp(int temperatureDelta) {
    switch (TemperaturePrivate ) {
        case 0:
            if (temperatureDelta == -100) {
                // already cold, do nothing
            } else {
            TemperaturePrivate += temperatureDelta;
            }
            break;
        case 100:
            TemperaturePrivate += temperatureDelta;
            break;
        case 200:
            if (temperatureDelta == 100) {
                // already hot, do nothing
            } else {
                TemperaturePrivate += temperatureDelta;
            }
            break;
        }
    }


}
