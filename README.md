# ToDo Application

A simple ToDo application built with Java and PostgreSQL to manage tasks efficiently.

## Project Structure

.gitignore
.idea/
pom.xml
README.md
src/
├── main/
│ ├── java/
│ │ ├── ToDo/
│ │ │ ├── model/
│ │ │ │ └── ToDo.java
│ │ │ ├── service/
│ │ │ │ ├── ToDoService.java
│ │ │ │ └── ToDoServiceImpl.java
│ │ │ ├── starter/
│ │ │ │ └── Starter.java
│ │ │ └── Main.java
target/

## Getting Started

### Prerequisites

- Java 17
- PostgreSQL
- Maven

### Setting Up the Database

1. Install PostgreSQL and create a database named `tasks`.
2. Update the database connection details in `ToDoServiceImpl.java`:

   ```java
   String URL = "jdbc:postgresql://localhost:5432/tasks";
   String USER = "postgres";
   String PASS = "your_password";

   ```

3. Create the task table in the tasks database:
   CREATE TABLE task (
   id SERIAL PRIMARY KEY,
   title VARCHAR(255) NOT NULL,
   status VARCHAR(50) NOT NULL
   );

Building the Project
Run the following command from the project directory:
mvn clean install

Running the Application
After building, execute the application using:
mvn exec:java -Dexec.mainClass="ToDo.Main"

Usage
The application provides a console-based interface with the following options:

See All Tasks
Add Task
Update Task
Remove Task
Exit

Project Files
Main.java: Entry point of the application.
Starter.java: Manages user interactions and console interface.
ToDo.java: Task model representation.
ToDoService.java: Service interface for task operations.
ToDoServiceImpl.java: Implements task management logic.

License
This project is licensed under the MIT License.
