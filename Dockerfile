FROM openjdk:17-slim
WORKDIR /app
COPY ./target/book-store-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","book-store-0.0.1-SNAPSHOT.jar"]