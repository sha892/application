FROM openjdk:8
LABEL org.opencontainers.image.source https://github.com/7shivam/application-emp
EXPOSE 8080
ADD target/app.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
