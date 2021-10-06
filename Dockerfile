FROM openjdk:11
EXPOSE 8080
ADD target/inetum-app.jar inetum-app.jar
ENTRYPOINT ["java", "-jar", "/inetum-app.jar"]