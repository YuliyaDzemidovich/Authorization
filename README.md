## Examples of authentication and authorization using Java & Spring

Each project is a maven module,
which can be run separately.

WARNING: Storing plain passwords is unsafe and not recommended in any environment. It is here only for educational purposes.

### Contents
1. In memory user with plain username and password.
2. JDBC user with plain username and password. The MySql database should be running locally in the docker container.

### How to run locally
#### Build project
Running maven command in the project root directory:
```
mvn clean install 
```

#### Module 1. In Memory User
1. Start Application.main method in your IDE.
2. Access http://localhost:8080/app/hello with credentials yuliya:12345
3. All further requests will use Cookie JSESSIONID with ID of your current session.
4. Login (any page being unauthorized or http://localhost:8080/app/login) and logout (http://localhost:8080/app/logout) are provided by Spring security automatically.

#### Module 2. JDBC User
1. Run docker compose command in the JdbcUser folder - that will create a MySQL database
```
docker compose up -d
```
2. Follow steps from module 1.

