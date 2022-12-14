FROM maven:3.8.5-amazoncorretto-17 as build

COPY . /sources/eventExperience
# Move into the directory.
WORKDIR /sources/eventExperience
# Build the package.
RUN mvn clean package

# -- Execute stage --

# Use JDK 11
FROM openjdk:11-jre-slim

# Copy over the built jar and configuration from the build stage.
WORKDIR /app
COPY --from=build /sources/eventExperience/target/experienceCenter-*.*.*-SNAPSHOT.jar /app/eventExperience.jar
COPY --from=build /sources/eventExperience/src/main/resources/application.properties /app/application.properties
# Run the eventExperience jar.
ENTRYPOINT [ "bash", "-c", "java -jar /app/eventExperience.jar -spring.config.location=file:///app/application.properties" ]
# Expose the port 8082 to the world, that is experience app is listening for API calls.
EXPOSE 8082
