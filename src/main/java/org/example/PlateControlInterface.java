// Copyright (c) TIOBE Software 2022

package org.example;

/**
 * The PlateControl interface provides the interface for the plate control class.
 * It contains the ability to change the temperature and get the temperature value.
 */
public interface PlateControlInterface {
    public int getTemperature();
    public void changeTemp(int temperatureDelta);
}
