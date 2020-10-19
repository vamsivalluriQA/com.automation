Feature: Arithmetic Opration

  @smoketest
  Scenario: Validate arithmetic opertation for given data
    Given launch app
    Then Validate operation with given data
      | Opratation | input1 | inout2 |
      | add        |     23 |     34 |
      | subtract   |     23 |     34 |
      | multiply   |     23 |     34 |
      | divide     |     23 |     34 |
    And close app
