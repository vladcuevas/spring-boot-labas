FROM openjdk:17.0.2-oracle

RUN adduser spring

COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

USER spring:spring

ENTRYPOINT [ "java", "-jar", "app.jar" ]