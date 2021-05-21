####
# This Dockerfile is used in order to build a distroless container that runs the Quarkus application in native (no JVM) mode
#
# Before building the container image run:
#
# ./mvnw package -Pnative
#
# Then, build the image with:
#
# docker build -f src/main/docker/Dockerfile.native-distroless -t quarkus/code-with-quarkus .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/code-with-quarkus
#
###
FROM registry.access.redhat.com/ubi8/ubi-minimal:8.3

ARG JAR=code-with-quarkus-1.0.0-SNAPSHOT.jar

COPY ./target/code-with-quarkus-1.0.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
