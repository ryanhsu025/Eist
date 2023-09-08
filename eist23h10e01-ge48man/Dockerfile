FROM openjdk:17-bullseye
WORKDIR /app
COPY ./build/libs/*.jar ./app.jar
COPY ./start.sh .
RUN chmod 770 start.sh
CMD ./start.sh
