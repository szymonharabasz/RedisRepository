FROM openjdk:8-jdk-alpine

COPY target/RedisRepository-0.0.1-SNAPSHOT.jar /

ENTRYPOINT ["java", "-jar", "RedisRepository-0.0.1-SNAPSHOT.jar"]