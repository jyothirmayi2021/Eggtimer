Feature: Verify counter in EggTimer website

  Scenario: Verify count down in timer
    Given Navigate to eggtimer application
    When Set counter to "100" "seconds"
    And Get count down values
