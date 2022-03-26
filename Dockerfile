FROM openjdk:8-jdk-alpine
WORKDIR /opt
ADD target/catalog*.jar catalog.jar
EXPOSE 9003
ENTRYPOINT ["java", "-jar", "/opt/catalog.jar", "--spring.config.location=/opt/config/application.properties"]