FROM maven:3.6.0-jdk-8-slim
VOLUME /tmp
COPY . .
RUN mvn clean package
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]