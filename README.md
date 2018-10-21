## Springboot2 Angular 6 App


### Requirements
Java 8
Maven


#### Compile
cd metric-app
mvn clean install

#### Run and Host (port 8080)
cd metric-app/metric-api
mvn spring-boot:run

#### Docker ####
cd metric-app/metric-api
mvn dockerfile:build
mvn dockerfile:push


#### Hosting for Development ####
cd metric-app/metric-api
mvn spring-boot:run

cd metric-app/metric-web
ng serve -o
