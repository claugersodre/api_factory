FROM adoptopenjdk/openjdk11:alpine
EXPOSE 8085
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
COPY /target/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
