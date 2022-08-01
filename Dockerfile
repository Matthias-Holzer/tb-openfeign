FROM eclipse-temurin:18-jre
COPY ./target/tb-client-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
