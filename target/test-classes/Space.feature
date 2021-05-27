#Open Source REST API for rocket, core, capsule, pad, and launch data
Feature: Validate space X API

  Scenario: Get latest launch
    When Get the latest launch
    Then Verify status code is "200"
    And Verify REST response for below values
      | flight_number | 109                |
      | mission_name  | Starlink-15 (v1.0) |

  Scenario: Get readiness of rocket
    Given Set Path Variable
      | rocket_id | falcon9 |
    When Get the rocket details
    Then Verify status code is "200"
    And Verify REST response for below values
      | rocket_id   | falcon9  |
      | rocket_name | Falcon 9 |
      | rocket_type | rocket   |

  Scenario: Get the core details
    Given Set Path Variable
      | core_serial | B1049 |
    When Get the core details
    Then Verify status code is "200"