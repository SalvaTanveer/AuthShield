# AuthShield - OTP-Based Authentication System 🔐

## 📌 Overview

**AuthShield** is a **Spring Boot-based OTP authentication system** designed to enhance security by verifying users through a one-time password (OTP) sent via email. This mini-project demonstrates **secure user authentication** using Spring Boot, Spring Data JPA, and JavaMail API.

## 🚀 Features

- 🔹 **User Authentication** via OTP
- 🔹 **Email-based OTP Verification**
- 🔹 **Secure OTP Expiration Handling**
- 🔹 **Spring Boot & JavaMail Integration**
- 🔹 **Spring Data JPA for User & Token Management**

## 🛠️ Technologies Used

- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **JavaMail API**
- **Thymeleaf**

## ⚙️ Setup & Installation

### **1️⃣ Clone the Repository**

```sh
git clone [https://github.com/your-username/AuthShield.git](https://github.com/SalvaTanveer/AuthShield.git)
cd AuthShield
```

### **2️⃣ Configure Database & Email SMTP**

Update the application.properties file with your MySQL database credentials and SMTP settings:

### **Database Configuration (MySQL)**

```sh
spring.datasource.url=jdbc:mysql://localhost:3306/authshield_db
spring.datasource.username=your-username
spring.datasource.password=your-db-password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

### **Email SMTP Configuration (Gmail)**

```sh
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
```

### **⚠️ Important: If using Gmail, you must enable 2-Factor Authentication (2FA) and generate an App Password**

### **3️⃣ Run the Application**

```sh
mvn spring-boot:run
```

### **4️⃣ Test the OTP Authentication**

Open

**[http://localhost:8080](http://localhost:8080)**

Enter login credentials
Check your email for the OTP
Enter the OTP to verify

### **📜 License**

This project is open-source and available under the MIT License.
