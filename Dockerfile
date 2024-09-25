FROM amazoncorretto:21
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
CMD apt-get update -y
EXPOSE 8080
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/application.jar"]