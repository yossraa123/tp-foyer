FROM openjdk:17-jdk-alpine
EXPOSE 8082
ADD tp-foyer/target/tp-foyer-5.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
