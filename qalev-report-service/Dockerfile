FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /qalev-report-app/src
COPY pom.xml /qalev-report-app

RUN mvn -f /qalev-report-app/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

COPY --from=maven-builder qalev-report-app/target/qalev-report-service-0.0.1-SNAPSHOT.jar /qalev-report-service/qalev-report-service-0.0.1-SNAPSHOT.jar
WORKDIR /qalev-report-service

EXPOSE 8080
ENTRYPOINT ["java","-jar","qalev-report-service-0.0.1-SNAPSHOT.jar"]