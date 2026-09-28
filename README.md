# Java JDBC CRUD Application

Is project me VS Code aur JDBC ka use karke ek Console-based Java CRUD (Create, Read, Update, Delete) application banayi gayi hai.

## Prerequisites (Kya-Kya Chahiye)
* Java JDK 17 ya upar ka version
* MySQL Server
* VS Code (Java Extension Pack ke saath)

## Database Setup
Apne MySQL me niche di gayi query chalayein:
```sql
CREATE DATABASE crud_db;
USE crud_db;
CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    email VARCHAR(50)
);
```

## How to Run (Kaise Chalayein)
1. Project ko VS Code me open karein.
2. `DBConnection.java` me apna MySQL username aur password badlein.
3. `App.java` file par jaakar **Run** button par click karein.
