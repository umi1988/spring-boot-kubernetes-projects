FROM eclipse-temurin:21-jdk-jammy

WORKDIR /spring-boot-kubernetes-mysql-docker-example

# copy whatever jar is produced by Maven (avoid hard-coded demo.jar)
COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]