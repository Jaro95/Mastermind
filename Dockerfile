FROM openjdk:17-jdk

COPY target/mastermind.jar .

EXPOSE 8080

ENTRYPOINT ["java","-jar", "mastermind.jar"]