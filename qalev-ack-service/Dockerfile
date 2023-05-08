FROM maven:3.8.4-openjdk-17 as maven-builder
COPY src /qalev-ack-app/src
COPY pom.xml /qalev-ack-app

RUN mvn -f /qalev-ack-app/pom.xml clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine

COPY --from=maven-builder qalev-ack-app/target/qalev-ack-service-0.0.1-SNAPSHOT.jar /qalev-ack-service/qalev-ack-service-0.0.1-SNAPSHOT.jar
WORKDIR /qalev-ack-service

EXPOSE 8081
ENTRYPOINT ["java", "-jar", "qalev-ack-service-0.0.1-SNAPSHOT.jar"]