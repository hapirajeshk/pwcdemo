FROM adoptopenjdk:11-jre-hotspot
EXPOSE 8080
ADD target/pwc-spring-boot.jar devops-automation.jar
ENTRYPOINT ["java","-jar","/devops-automation.jar"]
