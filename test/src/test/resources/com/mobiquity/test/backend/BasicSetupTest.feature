Feature: Basic setup tests

  Scenario: Configuration test
    Given baseUrl is configured to 'http://localhost:3000/'

  Scenario Outline: Test scenario context storage and cleanup
    Then context is empty
    When context stores value '<value>'
    Then '<value>' value is stored in the context
    Examples:
      | value |
      | Text1 |
      | Text2 |
