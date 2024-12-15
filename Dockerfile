FROM openjdk:21-jdk
COPY w24wNetflixBackendmongodb.jar /w24wNetflixBackendmongodb/w24wNetflixBackendmongodb-0.0.1-SNAPSHOT.jar
WORKDIR /w24wNetflixBackendmongodb
EXPOSE 8080
ENTRYPOINT ["java","-jar","w24wNetflixBackendmongodb-0.0.1-SNAPSHOT.jar"]