Feature: Flipkart Search Functionality

    @tc002
  Scenario:
    Given To launch the browser and enter url
    When Enter text in the Search field
    Then Search result should get displayed
    And Take screenshot and close browser
    
   @tc001 @smoke
  Scenario Outline: To test the search functionality with different values
    Given Launch the browser and enter url
    When Enter "<text>" in the Search field
    Then Search result should be displayed
    And Verify the result
    And Take the screenshot and close the browser

  Examples:
    | text     |
    | iPhone   |
    | Samsung  |
    | Laptop   |

    @tc003
    Scenario: Search product using data table
    Given To launch  browser and enter url
    When Enter the following text in the Search field
      | books       |
      | tv          |
      | watch       |
      | headphones  |
    Then Search results should get displayed for each product
    And Take screenshot  close browser