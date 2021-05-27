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
    And Verify REST response for below values
      | core_serial     | B1049                    |
      | original_launch | 2018-09-10T04:45:00.000Z |

#    Scenarios to test Space X API:
#  1. Get list of all launches
#  2. Get details of specific launch
#  3. Get history of all launches
#  4. Get all upcoming or scheduled launches
#  5. Get latest Launch
#  6. Get Next scheduled launch
#  7. Get Roadster details
#  8. Get all rocket details
#  9. Get the list of all dragons
#  10. Get the list of specific dragon
#  11. Get all cores
#  12. Get the details of specific core
#  13. Verify error codes for bad request, invalid authentication, invalid parameters
#
#