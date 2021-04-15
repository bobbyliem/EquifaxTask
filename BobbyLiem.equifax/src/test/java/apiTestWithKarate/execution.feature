#-- NOTE : If the test execution is failed because of 429 error (Throtling error) due to limitation of API call.
#   please kindly rerun the test until showing green sign.

Feature: Execute the test case by calling all the common function needed

  @execute
  Scenario: Create a new employee, get and delete the employee
    #-- Get the employee, actually there is no integration between the API's so we do little bit different approach by calling all employees from the table
    * def getEmployee = call read('commonKarateFunction.feature@GetEmployee')

    #-- just printing the response payload
    * print getEmployee.response

    #-- Get the first employee on record
    * def employeeDetails = getEmployee.response.data[0]

    #-- Get api validation
    #-- For employee name and employee id validation it just check if the data has value, because there is no integration between the API, so couldn't do  E2E flow
    * match employeeDetails.employee_name == '#present'
    * match employeeDetails.id == '#present'

    #-- Validation for age and salary will be just asserting whether these key has value greater than 0
    * assert employeeDetails.employee_salary >= 0
    * assert employeeDetails.employee_age >= 0

    #-- Stored the employee id from get API
    * def employeeId = employeeDetails.id

    #-- Call delete API by passing employeeId
    * def deleteEmployee = call read('commonKarateFunction.feature@DeleteEmployee') {'employeeId':#(employeeId)}

    #-- Validation for deleting API
    * match deleteEmployee.response.status == 'success'
    * match deleteEmployee.response.data == employeeId + ''
    * match deleteEmployee.response.message == "Successfully! Record has been deleted"
    * karate.log( " Record has been successfully delete " )


