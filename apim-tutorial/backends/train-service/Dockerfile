FROM adoptopenjdk/openjdk11:jre-11.0.14.1_1-alpine

COPY target/*.jar train-service.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/train-service.jar"]
