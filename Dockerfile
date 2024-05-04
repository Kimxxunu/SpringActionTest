FROM openjdk:11
ARG JAR_FILE=build/libs/
COPY ${JAR_FILE} SpringActionTest.jar
ENTRYPOINT ["java","-jar","/app.jar"]