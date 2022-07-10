FROM ubuntu:18.04
MAINTAINER tk1star2@gmail.com
RUN apt-get -y update
RUN apt-get -y install -y openjdk-11-jdk

#WORKDIR /Desktop/TK

EXPOSE 2022
#EXPOSE 8080
COPY ./okygogo/build/libs/okygogo-0.0.1-SNAPSHOT.jar .
CMD java -jar okygogo-0.0.1-SNAPSHOT.jar

