FROM maven:3.9.7-amazoncorretto-17 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app

RUN mvn clean install

FROM amazoncorretto:17-alpine-jdk

COPY --from=build /app/target/hello-docker-v1.jar /app/app.jar

ARG name
ENV DOCKER_APP $name

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]