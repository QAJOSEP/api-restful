FROM opendjk:17-alpine
EXPOSE 8080
ADD ./target/orrar-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]