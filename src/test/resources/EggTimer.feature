Feature: Verify counter in EggTimer website

  @test
  Scenario: Verify count down in timer
    Given Navigate to eggtimer application
    When Set counter to "59" "seconds"
    And Get count down values
