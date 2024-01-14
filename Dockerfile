FROM eclipse-temurin:17.0.9_9-jre

COPY target/unsecured.jar .
ENTRYPOINT ["java","-jar","/unsecured.jar"]