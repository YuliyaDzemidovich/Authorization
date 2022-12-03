## Examples of authentication and authorization using Java & Spring

Each project is a maven module,
which can be run separately.

WARNING: Storing plain passwords is unsafe and not recommended in any environment. It is here only for educational purposes.

### Contents
1. In memory user with plain username and password.
2. JDBC user with plain username and password. The MySql database should be running locally in the docker container.
3. OAuth 2.0 with Okta as an authorization server.

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

#### Module 3. Okta User
In Okta:
1. Create Okta admin account at https://developer.okta.com/
2. Create Web Java application.
3. Assign your user to the default group `Everyone`.
4. In your application settings set these:  

`Sign-in redirect URIs:`
```
http://localhost:9090/authorization-code/callback
```
`Sign-out redirect URIs:`
```
http://localhost:9090
```
In Spring Boot application:
5. (sensitive information!) Copy Okta app ID, secret and okta domain properties 
to the `application.properties` - refer to the `example.properties`.
6. Start Application.main method in your IDE.

Now, when accessing http://localhost:9090/hello page, you will be first redirected to the Okta login page
and after successful login you can see authorized /hello resource.  
Main page is available when unauthorized http://localhost:9090/  
but all other resources will require authorization.  
Logout is available via /logout endpoint.
