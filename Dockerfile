# Build Stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Package Stage
FROM openjdk:17.0.1-jdk-slim
COPY --from=build /app/target/financer_api-0.0.1-SNAPSHOT.jar financer_api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "financer_api.jar"]
