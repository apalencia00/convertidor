
FROM adoptopenjdk/openjdk11:alpine-jre

VOLUME  /tmp

ARG JAR_FILE=target/convertidor-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE}  app.jar



ENTRYPOINT ["java","-jar", "/app.jar"]

EXPOSE 8102