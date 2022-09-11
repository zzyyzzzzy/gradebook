FROM gradle:jdk11 as build
COPY . /app
WORKDIR /app
RUN gradle build -x test

FROM openjdk:11-oracle
EXPOSE 8080
COPY --from=build /app/build/libs/gradebook-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
ENTRYPOINT ["java","-jar","app.jar"]