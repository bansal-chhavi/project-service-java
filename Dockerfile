FROM openjdk:11
EXPOSE 9192
COPY target/product-service-0.0.1-SNAPSHOT.jar product-service.jar
CMD ["java" , "-jar" , "/product-service.jar"]