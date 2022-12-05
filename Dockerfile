FROM openjdk:11
EXPOSE 8080
ADD target/pwc-spring-boot.jar pwc-spring-boot.jar
ENTRYPOINT ["java","-jar","/pwc-spring-boot.jar"]

 