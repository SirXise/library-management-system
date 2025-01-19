# Library Management System (LMS)

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Setup and Installation](#setup-and-installation)
5. [Usage](#usage)
6. [Project Structure](#project-structure)
7. [Future Enhancements](#future-enhancements)
8. [License](#license)

---

## Introduction

The Library Management System (LMS) is a web-based application designed to simplify and streamline library operations, including managing books, members, borrowings, and generating reports. The system ensures efficient handling of overdue items, member records, and report generation for administrators.

---

## Features

- **Book Management**
    - Add, edit, and delete books.
    - View a list of available books.

- **Member Management**
    - Register new members.
    - Edit and delete existing member details.
    - View member details.

- **Borrowing Management**
    - Record book borrowings and returns.
    - Edit and delete existing borrowing details

- **Report Generation**
    - Generate overdue reports.
    - View a list of overdue members and associated books.

- **User-Friendly Interface**
    - Simple navigation across all features.
    - Clear table views for data presentation.

---

## Technologies Used

- **Backend**: Java with Spring Boot
- **Frontend**: Thymeleaf, HTML, CSS (Bootstrap framework)
- **Database**: MySQL
- **Tools**:
    - Maven for project management
    - Lombok for boilerplate code reduction
    - Jakarta Persistence for ORM

---

## Setup and Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-repo/library-management-system.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd library-management-system
   ```

3. **Configure the Database**:
    - Update `application.properties` with your database credentials:
      ```properties
      spring.datasource.url=jdbc:mysql://localhost:3306/library_db
      spring.datasource.username=your_username
      spring.datasource.password=your_password
      spring.jpa.hibernate.ddl-auto=update
      ```

4. **Build the Project**:
   ```bash
   mvn clean install
   ```

5. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

6. **Access the Application**:
    - Open your browser and navigate to: [http://localhost:8080](http://localhost:8080)

---

## Usage

### Navigation

- **Home**: Overview of the library system.
- **Books**: Manage library books.
- **Members**: Manage member details.
- **Borrowings**: Record and track borrowings.
- **Reports**: Generate and view overdue reports.

### Generating an Overdue Report
1. Navigate to the `Reports` section.
2. Click on "Generate Overdue Report."
3. View the generated report and details of overdue borrowings.

---

## Project Structure

- **src/main/java/com/example/lms2**:
    - `controller`: Handles HTTP requests and responses.
    - `model`: Contains entity classes like `Book`, `Member`, and `Borrowing`.
    - `repository`: Interfaces for database operations.
    - `service`: Implements business logic.

- **src/main/resources**:
    - `templates`: Thymeleaf templates for views.
    - `static`: CSS and JavaScript files.

---

## Future Enhancements

- Implement user authentication and role-based access control.
- Add analytics dashboards.
- Enable email notifications for overdue items.
- Support advanced search and filtering options.

---

## License

This project is licensed under the [MIT License](LICENSE).
