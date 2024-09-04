# wits
Task:Write a RESTful API for File Upload

## Technologies Used
* Java 17
* Spring Boot 3.3.3
* Maven
* Configuration
* To configure the file upload directory and maximum file size, edit the application.properties file:
````
# File upload directory
file.upload-dir=uploads/

# Maximum file size (in bytes, default is 5MB)
file.max-size=5242880
````

## API Endpoints
* Upload File
* URL: {{domain-url}}/api/files/upload
* Method: POST
* Content-Type: multipart/form-data
* Parameters:
  * file: The file to be uploaded.
 
  
