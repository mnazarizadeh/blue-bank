# Blue Bank
## Description

Blue Bank is a simple banking microservice application using Spring Boot.

The application has 4 components.
Each service component contains two module, one for service application and a shared spec.

1. customer-service: responsible for managing customers
2. account-service: responsible for managing accounts
3. transaction-service: responsible for managing transactions
4. common: provide basic models shared between microservices

## Technology spec

* In memory H2 database
* Java - 17
* Spring Boot 2.7.3
* SpringDoc Swagger-ui


## How to run
1. Clone project
```
git clone https://github.com/mnazarizadeh/blue-bank.git
```
2. Build the application
```
cd <PROJECT_HOME>
mvn clean install
```
3. Start the application
```
./start.sh
```
or move to each mng service application and run
```
cd <SERVICE_NAME>-service/<SERVICE_NAME>-mng
mvn spring-boot:start
```
4. Services are running on these ports
   * customer-mng: http://localhost:8080
   * account-mng: http://localhost:8081
   * transaction-mng: http://localhost:8082


5. Add new customers


6. Start creating account and inquiring customer details


7. To Stop application
```
./stop.sh
```

## Detail
You can access swagger on these addresses
   * [customer-mng](http://localhost:8080/api/swagger-ui.html)
   * [account-mng](http://localhost:8081/api/swagger-ui.html)
   * [transaction-mng](http://localhost:8082/api/swagger-ui.html)

Postman collection exists on **/doc** directory on the project root that contains API list and examples.