# Use a base image that contains Java
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file into the container
# COPY target/springboot-app-0.0.1-SNAPSHOT.jar springboot-app.jar
COPY target/demo-0.0.1-SNAPSHOT.jar springboot-app.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "springboot-app.jar"]
