## Starting project | Java EE/Complex Java assignment | JU19 | ITHS | Student Management System

### Project
* Create a project with CRUD functions (Create, Read, Update, Delete). This project is developed by
 me 
 
 ## Endpoints
  | Method        | Description   | URL   |
  | ------------- |:-------------:| -----|
  | GET      | Get all students | http://localhost:8080/student-management-system/api/v1/student/getAll|
  
  | Method        | Description   | URL        |
  | ------------- |:-------------|----------|
  | POST          | Add a new student, return a JSON body: | http://localhost:8080/student-management-system/api/v1/student/add
  |               | {"firstName": "Student",        |    |
  |               |   "lastName": "Test",           |    |
  |               |   "email": "sttudent@test.com", |    |
  |               |   "phoneNumber": "0707089568"   |    | 
  |               |   }                             |    |
  |               | The field "phoneNumber is not required, if the other required field is missing you will get a 400 bad request
  
  | Method        | Description| URL   |
  | ------------- |:-------------:| -----|
  | PUT           | Update a student input/list  | http://localhost:8080/student-management-system/api/v1/student/update
  |               | Send JSON file with the new modifications on the student record, you will be returned the modified list
  
  | Method        | Description| URL   |
  | ------------- |:-------------:| -----|
  | GET           | Search/find student by lastname  | http://localhost:8080/student-management-system/api/v1/student/findWithLastName/{lastname}
  |               | If the last name is not in the database you will be returned with a message "student with last not found
  
  | Method        | Description| URL   |
  | ------------- |:-------------:| -----|
  | DELETE        | Delete a student by sending its ID  | http://localhost:8080/student-management-system/api/v1/student/deleteStudent/{id}
  |               | If the ID cannot be find in the database you will get a message "Student with ID {id} does not exist, try again, or if deleted you will get message" Student with ID {id} is deleted." 
     
    
    
  
  
 