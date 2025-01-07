FROM openjdk:21-jdk
ADD target/temporary.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
