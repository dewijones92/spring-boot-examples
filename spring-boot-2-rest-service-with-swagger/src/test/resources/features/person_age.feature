Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Today is or is not Friday
    Given today is "2015-06-02T21:34:33.616Z"  and Persons dob is "<dob>"
    When I ask their age
    Then I should be told "<age>"

    Examples:
      | dob                    | age |
      | 1992-06-02T21:34:33.616Z | 40 |