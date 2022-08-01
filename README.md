# cooker-example
Example project to show how unit tests can be written in Java/Gherkin.

The application has 3 layers: Main (Application level), CookerPlate (application logics) and PlateControl (simulated hardware control).

The CookerPlateTest.java shows examples of tests with and without mocks (using Mockito) and asserts.
The statetransitioning.feature file shows a full state transitioning test with and without scenario outline.
It even concludes incorrectgherkin.feature with the aim of braking as many coding standard violations as possible.
