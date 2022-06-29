// Copyright (c) TIOBE Software 2022

package org.example;

/**
 * Representation of a cooker plate with a warm/cold status.
 */
public class CookerPlate {

    private String PrivateTemperature = "cold";
    final PlateControlInterface myplateControl;

    public CookerPlate(){
        this(new PlateControl());
    }

    public CookerPlate(final PlateControlInterface plateControl) {
        this.myplateControl = plateControl;
    }

     public String Temperature() {
        switch (myplateControl.getTemperature()){
            case 0:
                PrivateTemperature = "cold";
                break;
            case 100:
                PrivateTemperature = "warm";
                break;
            case 200:
                PrivateTemperature = "hot";
                break;
        }
        return PrivateTemperature;
    }

    public void heat() {

        if (myplateControl.getTemperature()<200) {
            myplateControl.changeTemp(100);
        }
    }

    public void cool() {

        switch (myplateControl.getTemperature()) {
            case 0:
                myplateControl.changeTemp(0);
                break;
            case 100:
                myplateControl.changeTemp(-100);
                break;
            case 200:
                myplateControl.changeTemp(-100);
                break;
            default:
                myplateControl.changeTemp(0);
        }
    }
}
