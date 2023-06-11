Feature:  To Validate the dropdown values

  @DropdownValidation
  Scenario: To handle the static dropdown
    Given User launch the browser and navigate to the URL
    When User selects the specifc dropdown value
    And User iterates the dropdownvalues

  @Dynamic
  Scenario: To Handle the dynamic dropdown
    Given User launch the browser and navigate to the URL
    When handle dynamic dropdown

  @Actions
  Scenario: Mouse Actions
    Given User launch the browser and navigate to the URL
    When handle the mouse actions

    @DragAndDrop
  Scenario: Drag and drop
    Given User launch the browser and navigate to the URL
    When handle the drag and drop

  @AutoSugg
  Scenario: Auto suggestive dropdown
    Given User launch the browser and navigate to the URL
    When Handle Auto sugg

  @Cal
  Scenario:  To Handle the calander dropdown
    Given User launch the browser and navigate to the URL
    When Handle the Cal icon