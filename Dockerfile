FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} car-service.jar
ENTRYPOINT ["java","-jar","/car-service.jar"]
EXPOSE 4444

