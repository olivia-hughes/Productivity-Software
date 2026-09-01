# Effort Log
This markdown file acts as an audit trail for me to journal the things I had contributed on certain days, and why I did them (most recent -> earliest).

### 01/09/26
I have finalised the files found in `productivity-app\src\main\java\com\example\productivity_app\model`, which 'model' the databases. They mirror all of the entities found in each table in productivitydb. The next step will be creating the rest of the repositories for the tables. These repository files will consist of methods that use various SQL requests to achieve specific critera and will provide 'endpoints' connecting the the tables in the database. 

### 31/08/26
Today I will be planning clearly what I want parts of the app to do, and attempt to create a starting base for the rest of the work ahead. This will clearly outline everything that I need to do per sector, and how specific things work together. From here, I can start writing the code for the APIs, ready for front-end creation & integration.


### 30/08/26
I started this project as I wasn't happy with productivity apps on the market, and I wanted to further my own experience. I already gained knowledge in using springboot, maven, and associated libraries during my time working in a team creating a diet-tracking application for the University of Essex, however, I wanted to work on this project independently so I could gain experience in all aspects. 

To start, I installed and started my own MySQL servers which will host the database, 'productivitydb', and gave it a good baseline to start with. At the time of typing this, this consists of:
```bash
+--------------------------+
| Tables_in_productivitydb |
+--------------------------+
| categories               |
| goal_tasks               |
| goals                    |
| note_categories          |
| notes                    |
| reminders                |
| tags                     |
| tasks                    |
| users                    |
+--------------------------+
```

The next step was to initialise spring boot. I used the [springboot initialiser](https://start.spring.io/) to set up a good base for the project with the following settings:

```bash
Project: Maven
Language: Java
Spring Boot: 4.1.1

Project Metadata
----------------------------
- Group: com.example
- Artiface: productivity-app
- Package name: com.example.productivity-app
- Packaging: Jar
- Configuration: Properties
- Java: 26 (despite knowing that Java21 had long-term support, I had opted to use Java26 as I wanted to experiment with a more up-to-date Java version).

Dependencies
----------------------------
- Spring Web [WEB]
- Spring Data JPA [SQL]
- MySQL Driver [SQL]
- Validation [I/O]
- Spring Security [SECURITY]
```

Initialially, I had issues running spring-boot from `.\mvnw.cmd spring-boot:run`, this was because I had to provide more information to `application.properties` for the project in order to link it to `productivitydb`. 

As I had worked on the backend of a similar project (aforementioned diet-tracker), I knew the best place to start was creating folders for controllers, models, repositories, and services. From here, I began working in `Task.java` as a starting point. 
Other files and such created this session:
- TaskRepository.java
