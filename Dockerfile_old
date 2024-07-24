FROM registry.access.redhat.com/ubi8/openjdk-11-runtime:latest
USER 1001

# We make four distinct layers so if there are application changes the library layers can be re-used
COPY target/quarkus-app/lib/ lib/
COPY target/quarkus-app/*.jar .
COPY target/quarkus-app/app/ app/
COPY target/quarkus-app/quarkus/ quarkus/

EXPOSE 8080
ENTRYPOINT [ "java", "-jar","quarkus-run.jar" ]
