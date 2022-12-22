FROM openjdk:8-jdk-alpine
COPY build/libs/MessageConsumer-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9092
ENTRYPOINT ["java","-jar","/app.jar"]
