FROM openjdk:14-alpine
COPY target/cookbook-*.jar cookbook.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "cookbook.jar"]