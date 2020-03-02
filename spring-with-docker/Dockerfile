FROM openjdk:8
ADD out/artifacts/demo_jar/demo.jar spring-with-docker.jar
EXPOSE 8050
ENTRYPOINT ["java","-jar","spring-with-docker.jar"]