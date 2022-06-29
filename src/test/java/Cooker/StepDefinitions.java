package Cooker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.CookerPlate;

import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {

    // Set up the Cookerplate.
    final CookerPlate cookerPlate = new CookerPlate();
    @Given("cookerplate is cold")
    public void cookerplate_is_turned_off() {
        // Ensure cooker plate is cold by repeating cooling it.
        while (!cookerPlate.Temperature().equals("cold")) {
            cookerPlate.cool();
        }
    }
    @Given("cookerplate is warm")
    public void cookerplate_is_warm() {
        // First bring it to guaranteed cold, and then one heat step.
        while (!cookerPlate.Temperature().equals("cold")) {
            cookerPlate.cool();
        }
        cookerPlate.heat();
    }
    @Given("cookerplate is hot")
    public void cookerplate_is_hot() {
        // Write code here that turns the phrase above into concrete actions
        while (!cookerPlate.Temperature().equals("hot")) {
            cookerPlate.heat();
        }
    }

    @When("I heat the plate")
    public void i_turn_cooker_plate_on() {
        // Heat up the cooker plate one step.
        cookerPlate.heat();
    }

    @When("I cool the plate")
    public void i_cool_the_plate() {
        // Cool down the cooker plate one step.
        cookerPlate.cool();
    }
    @Then("I should have a cold cookerplate")
    public void i_should_have_a_cold_cookerplate() {
        // Call the Temperature function and determine if it's cold.
        assertEquals(cookerPlate.Temperature(), "cold");
    }
    @Then("I should have a warm cookerplate")
    public void i_should_have_a_warm_cookerplate() {
        // Call the Temperature function and determine if it's warm.
        assertEquals(cookerPlate.Temperature(), "warm");
    }
    @Then("I should have a hot cookerplate")
    public void i_should_have_a_hot_cookerplate() {
        // Call the Temperature function and determine if it's hot.
        assertEquals(cookerPlate.Temperature(), "hot");
    }


}
