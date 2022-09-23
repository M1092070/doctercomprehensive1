FROM openjdk:17
ADD target/spring-boot-doctor-data3-0.0.1-SNAPSHOT.jar spring-boot-doctor-data3.jar
ENTRYPOINT ["java","-jar","spring-boot-doctor-data3.jar"]
