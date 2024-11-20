# WellNess360 Task Management System  

Welcome to the **WellNess360 Task Management System**! This project is a **Spring Boot-based Task Management System** that utilizes Spring Security, custom configurations, and an H2 in-memory database. It supports RESTful APIs for managing tasks and user registration.

---

## **Project Link**  
GitHub Repository: [WellNess360_TASK](https://github.com/hemanthjinnala7/WellNess360_TASK/tree/main)

---

## **Requirements**  
To run this project locally, ensure you have the following installed:  

1. **Java**: Version 8 or later  
2. **Spring Boot**: Latest version compatible with the project  
3. **IntelliJ IDEA**: Recommended for easier setup  
4. **Maven**: For dependency management and building the project  
5. **Postman**: To test the APIs  

---

## **Getting Started**  

### Clone the Repository  
To get a copy of the project up and running, clone the repository:  

```bash
git clone https://github.com/hemanthjinnala7/WellNess360_TASK.git
cd WellNess360_TASK
```

---

### **Steps to Run**  
1. Open the project in **IntelliJ IDEA**.  
2. Navigate to the `src/main/resources/application.properties` file to check the configuration for H2.  
3. Run the `WellNess360TaskApplication` class.  
4. Access the application:  
   - H2 Console: [http://localhost:9090/h2-console](http://localhost:9090/h2-console)  
   - Default APIs start at: `http://localhost:9090/api/`  

---

## **API Documentation**  

### **Task APIs**

| Method | URL                              | Description                             |
|--------|----------------------------------|-----------------------------------------|
| **GET**    | `/api/tasks`                     | Retrieve all tasks                      |
| **GET**    | `/api/tasks/{id}`                | Retrieve a specific task by ID          |
| **POST**   | `/api/tasks`                     | Add a new task                          |
| **PUT**    | `/api/tasks/{id}`                | Update an existing task                 |
| **PATCH**  | `/api/tasks/{id}/complete`       | Mark a task as complete                 |
| **DELETE** | `/api/tasks/{id}`                | Delete a task by ID                     |

**Sample Task JSON Request**:  

```json
{
  "title": "Complete Project",
  "description": "Finalize and submit project documentation",
  "status": "PENDING"
}
```

---

### **User APIs**  

| Method | URL                              | Description                             |
|--------|----------------------------------|-----------------------------------------|
| **POST**   | `/api/register`                 | Register a new user                     |

**Sample User JSON Request**:  

```json
{
  "id":1,
  "username": "john_doe",
  "password": "securepassword",
}
```

---

## **Security**  

The project includes **Spring Security** with custom configurations. By default, user authentication and role-based authorization are integrated. You can extend these configurations as needed.

---

## **Database**  

- **H2 Database** is used as the in-memory database for this project.  
- Access H2 Console at: [http://localhost:9090/h2-console](http://localhost:9090/h2-console)  
- Default credentials:  
  - **JDBC URL**: `jdbc:h2:mem:testdb`  
  - **Username**: `hemanth`  
  - **Password**:  

---

## **Contributing**  

1. Fork the repository  
2. Create a feature branch (`git checkout -b feature-branch-name`)  
3. Commit your changes (`git commit -m "Add some feature"`)  
4. Push to the branch (`git push origin feature-branch-name`)  
5. Open a pull request  

