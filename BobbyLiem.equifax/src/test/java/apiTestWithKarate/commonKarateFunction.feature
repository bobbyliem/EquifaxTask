
  Feature: This feature is for story common method/function so we can re-use it in future.


    Background: We define all common variable in this part, If you use TestNG or Junit it will be similar as @beforeMethod

      * def baseUrl = 'http://dummy.restapiexample.com/'
      * def endPointGet = 'api/v1/employees'
      * def endPointDelete = 'api/v1/delete'


    @GetEmployee
    Scenario: Get all employee

      Given url baseUrl
      And path endPointGet
      And header Content-Type = 'application/json'
      When method get
      Then status 200

    @DeleteEmployee
    Scenario: DeleteEmployee by passing the employeeId

      * def employeeId = employeeId

      Given url baseUrl
      And path endPointDelete + '/' + employeeId
      And header Content-Type = 'application/json'
      When method delete
      Then status 200
