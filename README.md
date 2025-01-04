# TP for Installation and SpringBoot

## 1. Description of the TP and its purpose.

**TP Purpose:**

Through this project, you will understand the interaction flow between the front end, back end, and database. Additionally, the implementation of this project provides the necessary tools and technical foundation for the future development of ERP and MES systems.



**Project Introduction:**

This project utilizes React for the front end, SpringBoot + MyBatis for the back end, and PostgreSQL for the database. The core functionality of the project involves a login page on the front end, where users enter their username and password. The back end receives the request, queries the database, and verifies whether the user exists. If the user is found, the back end returns a "login successful" message, and the front end displays the corresponding login success information.



## 2. Environment Requirements:

**Necessary tools:**

- **JDK17**:  Cette TP utilise version 17

- **Node.js and npm**: Used for front-end development to ensure the React project runs correctly.

- **Docker**: Docker will be used in subsequent projects.

- **PostgreSQL**: It is recommended to deploy the database using Docker to simplify environment configuration and management.



**IDE:**

- **IntelliJ IDEA** : It is recommended to use **IntelliJ IDEA** for back-end development to efficiently manage SpringBoot projects.

- **VsCode** : Used for front-end development



**Other Tools:**

- **SQL Visualization Tools**: Tools like **DBeaver**, **SQLyog**, or **Navicat**. Choose the tool that best suits your needs to facilitate easier database management.

- **PostMan**: A tool used to test back-end APIs, helping to verify whether the APIs work as expected. 



## 3. Download front-end and back-end code





## 4. Execute SQL File

Use the “TP.sql” file to create the "users" table and insert data:

<img src="/Users/jiaoyongshun/Library/Application%20Support/typora-user-images/%E6%88%AA%E5%B1%8F2025-01-03%2022.40.22.png" alt="截屏2025-01-03 22.40.22" style="zoom:50%;" />

Then you will see there is data in the database

<img src="https://p.ipic.vip/dbzs1x.png" alt="截屏2025-01-03 22.41.20" style="zoom:50%;" />



## 5. Backend Introduction

- Backend structure

```java
Login/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/example/login/
│       │       ├── controller/
│       │       │   └── UserController.java       # Controller class that handles requests from the frontend
│       │       ├── mapper/
│       │       │   └── UserMapper.java           # Database access interface used for executing SQL operations
│       │       ├── proj/
│       │       │   └── User.java                 # Entity class mapping the fields of the database table
│       │       ├── service/
│       │       │   ├── impl/
│       │       │   │   └── UserServiceImpl.java  # Implementation of the service class containing business logic
│       │       │   └── UserService.java          # Service interface defining business methods
│       │       └── LoginApplication.java         # Main application class, containing the `main` method
│       ├── resources/
│       │   ├── mapper/
│       │   │   └── user-mapper.xml               # MyBatis SQL mapping file, defining specific SQL queries
│       │   ├── static/                           # Static resource directory for files like CSS and JS
│       │   └── templates/                        # Template directory, usually for Thymeleaf template files
│       └── application.properties                # Configuration file for the project, including database connection and global settings
└── pom.xml                                       # Maven project configuration file for managing dependencies and build process

```

- Configure in the `application.properties` file.

```
spring.datasource.url= #url of your postgres database
spring.datasource.username= #username of your postgres database
spring.datasource.password= #password of your postgres database
spring.datasource.driver-class-name=org.postgresql.Driver
```

- Run the `LoginApplication.java` file to start the backend project.

<img src="https://p.ipic.vip/udv6ca.png" alt="截屏2025-01-03 22.53.43" style="zoom: 33%;" />

- If the startup is successful, you will see the following output:

<img src="https://p.ipic.vip/ij0813.png" alt="截屏2025-01-03 22.56.31" style="zoom: 50%;" />



## 6. Use Postman to test the backend API :

- Postman is a powerful API testing tool mainly used for the following purposes:

  - **API Testing**: Send HTTP requests (GET, POST, PUT, DELETE, etc.) and verify if the API responses meet expectations.
  - **Debugging and Development**: Used during the development process to debug and validate the functionality and performance of APIs.

- How to use:

  - Create your Workspaces:

    <img src="https://p.ipic.vip/by1rfp.png" alt="截屏2025-01-03 23.09.57" style="zoom: 33%;" />

  - Create a Http Request:

  <img src="https://p.ipic.vip/z24zc3.png" alt="截屏2025-01-03 23.10.43" style="zoom: 50%;" />

  - Simulate an HTTP request.

  Use a POST request. The HTTP request path should be determined based on the backend interface path you want to test. The backend interface paths are defined in the Controller folder

  <img src="https://p.ipic.vip/kycqrj.png" alt="截屏2025-01-03 23.19.21" style="zoom: 50%;" />

  - Observe the return result and backend logs.

  <img src="https://p.ipic.vip/hmnyki.png" alt="截屏2025-01-03 23.25.17" style="zoom:50%;" />

  <img src="https://p.ipic.vip/114et5.png" alt="截屏2025-01-03 23.25.02" style="zoom:50%;" />

  

## 7. Frontend Introduction:

- Use `npm install` to download and install the required dependencies for the frontend

- Use `npm start` to launch the frontend application.

![截屏2025-01-04 00.33.43](https://p.ipic.vip/b7vurb.png)

- Open the frontend page to access it.

![截屏2025-01-04 00.34.02](https://p.ipic.vip/zjgze0.png)

- Enter the username and password to observe different page responses.

If the username and password you entered exist in the database, it will return "Login Successful," indicating that you have logged in successfully. Otherwise, you will see "Invalid username and password," meaning the login attempt has failed.



## 8. View the frontend call path through debug mode.

<img src="https://p.ipic.vip/hd3iy4.png" alt="截屏2025-01-04 00.37.49" style="zoom:50%;" />

- Set a breakpoint at the API in the Controller, and you will notice that the username and password information from the frontend is successfully passed to the backend. Then, the system calls the `userService.login(username, password)` method to determine whether the credentials exist in the database.

![截屏2025-01-04 00.39.10](https://p.ipic.vip/mbhf9h.png)

- Set a breakpoint in the `login()` method of `userServiceImpl`, and you will observe that the `login()` method calls the `getUsernameAndPassword()` method of the `userMapper` type. If the user exists in the database, the `user` object will not be null, and "Login Successful" will be returned. Otherwise, if the `user` object is null, "Login False" will be returned.

![截屏2025-01-04 00.44.47](https://p.ipic.vip/hyl3j5.png)

## 9. Attempt to run the ERP system.:

Please refer to the **deployment.guide** file of the ERP system and attempt to run the system.

⚠️ The files `docker_secrets_files.sh` and `generate_certificate_password.sh` are related to security and are not included in the project code. We will provide the contents of these two files during the class.























 