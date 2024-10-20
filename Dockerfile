FROM openjdk:21-jdk-slim

RUN mkdir /app

WORKDIR /app

COPY ./code/boot/target/boot-0.2.0-SNAPSHOT.jar /app/springapi-docker.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dspring.profiles.active=local", "-jar", "springapi-docker.jar"]