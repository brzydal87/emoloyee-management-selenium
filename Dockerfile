FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/emoloyee-management-selenium-jar.jar /app/emoloyee-management-selenium-jar.jar
ENTRYPOINT ["java", "-jar", "emoloyee-management-selenium-jar.jar"]
