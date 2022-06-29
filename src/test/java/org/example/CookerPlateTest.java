package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


// @RunWith attaches a runner with the test class to initialize the test data
// @RunWith(MockitoJUnitRunner.class)
class CookerPlateTest {

    /**
     * Check Temperature function of CookerPlate class.
     * Mocking PlateControl class.
     */
    @Test
    void plateControlMocked(){

        PlateControlInterface mockplateControlInterface = mock(PlateControlInterface.class);
        final CookerPlate cookerPlate = new CookerPlate(mockplateControlInterface);

        when(mockplateControlInterface.getTemperature()).thenReturn(100);
        assertEquals("warm", cookerPlate.Temperature());
    }

    /**
     * Check continuation of running the function after an assertion is false.
     * As the Cookerplate will be cold when initiated, the assertEquals will be false.
     * This means the line after will not be executed.
     *
     */
    @Test
    void ContinuationAfterInsert(){
        final CookerPlate cookerPlate = new CookerPlate();
        assertEquals("hot",cookerPlate.Temperature() );
        System.out.println("This statement is not executed as the assert is false");
    }

    /**
     * Check continuation of running the function after an exception with try-catch.
     * As the Cookerplate will be cold when initiated, the Exception will be thrown.
     * As the exception is catched, the code continues.
     */
    @Test
    void ContinuationAfterException(){
        final CookerPlate cookerPlate = new CookerPlate();
        try {
            if (cookerPlate.Temperature().equals("hot")) {
                System.out.println("Cold as expected");
            } else {
                throw new Exception("Wrong temperature, not hot");
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("This line will be executed as the exception is caught.");
    }

    /**
     * Heating up a plate
     */
    @Test
    void heating_plate() {
        final CookerPlate cookerPlate = new CookerPlate();
        assertEquals("cold",cookerPlate.Temperature() );
        cookerPlate.heat();
        assertEquals("warm", cookerPlate.Temperature());
        cookerPlate.heat();
        assertEquals("hot",cookerPlate.Temperature());
    }

    /**
     * Heating up 2 plates
     */
    @Test
    void heating_two_plates() {
        final CookerPlate cookerPlate1 = new CookerPlate();
        final CookerPlate cookerPlate2 = new CookerPlate();
        assertEquals("cold", cookerPlate1.Temperature());
        assertEquals("cold", cookerPlate2.Temperature());
        cookerPlate1.heat();
        assertEquals("warm", cookerPlate1.Temperature());
        assertEquals("cold", cookerPlate2.Temperature());
        cookerPlate2.heat();
        assertEquals("warm", cookerPlate1.Temperature());
        assertEquals("warm", cookerPlate2.Temperature());
        cookerPlate2.heat();
        assertEquals("warm", cookerPlate1.Temperature());
        assertEquals("hot",cookerPlate2.Temperature());
    }

    /**
     * Heating and cooling a plate
     */
    @Test
    void Heating_and_cooling_plate(){
        final CookerPlate cookerPlate = new CookerPlate();
        assertEquals(cookerPlate.Temperature(), "cold");
        cookerPlate.heat();
        assertEquals(cookerPlate.Temperature(), "warm");
        cookerPlate.cool();
        assertEquals(cookerPlate.Temperature(), "cold");
    }

    /**
     * This test case performs a state based test technique.
     * It reaches full state transition coverage.
     * Hitting all possible transitions in the diagram.
     */
    @Test
    void fullStateTransitionCoverage(){
        final CookerPlate cookerPlate = new CookerPlate();
        assertEquals(cookerPlate.Temperature(), "cold");
        cookerPlate.cool();
        assertEquals(cookerPlate.Temperature(), "cold");
        cookerPlate.heat();
        assertEquals(cookerPlate.Temperature(), "warm");
        cookerPlate.heat();
        assertEquals(cookerPlate.Temperature(), "hot");
        cookerPlate.heat();
        assertEquals(cookerPlate.Temperature(), "hot");
        cookerPlate.cool();
        assertEquals(cookerPlate.Temperature(), "warm");
        cookerPlate.cool();
        assertEquals(cookerPlate.Temperature(), "cold");
    }

}
