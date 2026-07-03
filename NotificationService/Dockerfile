FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/NotificationService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "app.jar"]
