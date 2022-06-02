FROM adoptopenjdk/openjdk11:jre-11.0.14.1_1-alpine

COPY target/*.jar train-schedule-info.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/train-schedule-info.jar"]
