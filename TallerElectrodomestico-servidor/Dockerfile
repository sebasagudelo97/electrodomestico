FROM openjdk:11-jdk-slim
VOLUME /tmp
EXPOSE 8080
ADD build/libs/TallerElectrodomestico-0.0.1-SNAPSHOT.jar springbootpostgresqldocker.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/TallerElectrodomestico.jar"]