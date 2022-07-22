Feature: Select PO ID from PA
  Scenario: Selecting PO ID from PA
    Given I click on Persons menu option
    When I type 18816 into PO ID (exact match)
    Then I click on search
    Then I Assert 18816 matches 18816
    Then I click on logout