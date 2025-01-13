# Step 1: Use a lightweight OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy your JAR file into the container
COPY build/libs/redisexample-0.0.1-SNAPSHOT.jar app.jar

# Step 4: Expose the application's port (default for Spring Boot is 8080)
EXPOSE 8085

# Step 5: Define the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
