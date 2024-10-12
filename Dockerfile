FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/financer_api-0.0.1-SNAPSHOT.jar financer_api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "financer_api.jar"]