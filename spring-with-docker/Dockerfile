FROM openjdk:8
ADD out/artifacts/demo_jar/spring-with-docker.jar spring-with-docker.jar
EXPOSE 8050
ENTRYPOINT ["java","-jar","spring-with-docker.jar"]