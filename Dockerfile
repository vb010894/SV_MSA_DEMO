FROM openjdk
LABEL authors="VladiBoy"
WORKDIR app
COPY ./demo-first-service/target/demo-first-service-0.0.1-SNAPSHOT.jar .

CMD ["java", "-jar", "demo-first-service-0.0.1-SNAPSHOT.jar"]