FROM  openjdk
WORKDIR /app
COPY ./targets/*.jar /app.jar
CMD ["java","-jar","app.jar"]
