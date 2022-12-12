FROM openjdk:8
EXPOSE 8080
ADD target/pwc-spring-boot.jar devops-automation.jar
ENTRYPOINT ["java","-jar","/devops-automation.jar"]
