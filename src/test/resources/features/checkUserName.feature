Feature: Verify if user can log in

  Scenario Outline: Correctly Check Password and UserName Validity

    Given Go to Login Page  <nameUser> and <password>
    And Fill data in field <expected>

    Examples:
      |nameUser             |password           |expected                               |
      |VolodjaZ             |Vova!1234567890    |No account found with that username.   |