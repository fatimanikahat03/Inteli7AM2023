Feature: Validate the Table values

  @Table
  Scenario: To iterate the table values
    Given user naviagates and click on the table
    When user iterates the value from column one
    And user iterates the value from column two
  # And iterate the acq table values
    And hello