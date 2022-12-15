FROM maven:3.8.5-amazoncorretto-17 as build

COPY . /sources/beckn-exp-apis
# Move into the directory.
WORKDIR /sources/beckn-exp-apis
# Build the package.
RUN mvn clean package

# -- Execute stage --

# Use JDK 11
FROM openjdk:11-jre-slim

# Copy over the built jar and configuration from the build stage.
WORKDIR /app
COPY --from=build /sources/beckn-exp-apis/target/eventExperience-*.*.*-SNAPSHOT.jar /app/beckn-exp-api.jar
COPY --from=build /sources/beckn-exp-apis/src/main/resources/application.properties /app/application.properties
# Run the beckn-exp-api jar.
ENTRYPOINT [ "bash", "-c", "java -jar /app/beckn-exp-api.jar -spring.config.location=file:///app/application.properties" ]
# Expose the port 8081 to the world, that is experience app is listening for API calls.
EXPOSE 8081
