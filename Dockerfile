FROM openjdk:21-jdk
COPY app.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","w24wNetflixBackendmongodb-0.0.1-SNAPSHOT.jar"]