FROM openjdk:21-jdk-slim

RUN mkdir /app

WORKDIR /app

COPY app.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "springapi-docker.jar"]