# Web Market - Student Semester Project
**Java MVC Framework for Web Market Application**  
> Student project implementing an online marketplace using MVC architecture

This project presents a functional web application for an online marketplace (web market), developed as a semester project for the Web Engineering course. The application uses a custom mini-framework based on MVC (Model-View-Controller) architecture, integrating session management, security, database operations, and view components.

## About the Project
Semester work created for the [**Web Engineering**](https://webengineering-univaq.github.io) course at University of L'Aquila. The code is structured according to the course syllabus and serves as a practical implementation of a web marketplace with these features:
- User accounts with roles (customer/seller)
- Product and category management
- Shopping process (cart, orders)
- Admin interface

*The project will be presented during the 19th lecture of the course. Code may be updated before presentation.*

---

## Installation & Setup
This is a Maven-based project. Local setup instructions:

### 1. Build the Project
Open in any Maven-compatible IDE (NetBeans, Eclipse, IntelliJ)

### 2. Platform Selection
**Switch to appropriate branch for your platform:**
- `JEE`: For **JavaEE 8 + Apache Tomcat 9**
- `JKEE`: For **JakartaEE 10 + Apache Tomcat 10**

### 3. Database Configuration
Requires **MySQL 8+**:
1. Run the SQL setup script as root:
   ```sql
   SOURCE /path/to/project/database_setup.sql;