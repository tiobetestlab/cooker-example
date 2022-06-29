package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlateControlTest {

    /**
     * Check getTemperature function of PlateControl class.
     *
     */
    @Test

    void InitializationPlateControl() {
        final PlateControl plateControl = new PlateControl();
        assertEquals(0, plateControl.getTemperature());
    }
}
