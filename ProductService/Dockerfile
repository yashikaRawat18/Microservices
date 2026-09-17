FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY target/ProductService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8093
ENTRYPOINT ["java", "-jar", "app.jar"]
