Feature: Jsonplaceholder API Post validation

  Background:
    Given jsonplaceholder API service is set up

  Scenario Outline: Filter user by username - <username>
    When user requests a user with username '<username>' from jsonplaceholder API service
    Then a list of users is returned
    And the list of users contains details of '<username>' user
    Examples:
      | username  |
      | Delphine  |
      | Bret      |
      | Antonette |

  Scenario Outline: Filter users by invalid username - <username>
    When user requests a user with username '<username>' from jsonplaceholder API service
    Then a list of users is returned
    And the list of users is empty
    Examples:
      | username |
      | Jorj     |
      |          |

  Scenario Outline: Filter posts by userId - <username>
    When user requests a list of posts by '<username>' user from jsonplaceholder API service
    Then a list of posts by the user is returned
    And the list of posts is not empty
    Examples:
      | username  |
      | Delphine  |
      | Bret      |
      | Antonette |

  Scenario Outline: Filter posts by invalid userId - <username>
    When user requests a list of posts by '<username>' user from jsonplaceholder API service
    Then a list of posts by the user is returned
    And the list of posts is empty
    Examples:
      | username |
      | Joffrey  |
      |          |

  Scenario Outline: Filter comments by postId - <username>
    When user requests a list of posts by '<username>' user from jsonplaceholder API service
    Then a list of posts by the user is returned
    And the list of posts is not empty
    Examples:
      | username  |
      | Delphine  |
      | Bret      |
      | Antonette |

  Scenario Outline: Filter comments by invalid postId - <username>
    When user requests a list of posts by '<username>' user from jsonplaceholder API service
    Then a list of posts by the user is returned
    And the list of posts is empty
    Examples:
      | username |
      | Delphine |
      | Bret     |

  Scenario Outline: Validate comments emails under user's posts - <username>
    When user requests a user with username '<username>' from jsonplaceholder API service
    Then a list of users is returned
    And the list of users contains details of '<username>' user

    When user requests a list of posts by the user from jsonplaceholder API service
    Then a list of posts by the user is returned
    And the list of posts is not empty

    When comments for each post from the list of posts are requested from jsonplaceholder API service
    Then a list of comments for each post by the user is returned
    And all comments in the list of comments have valid emails
    Examples:
      | username |
      | Delphine |
