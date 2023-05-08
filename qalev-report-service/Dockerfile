FROM alpine:3.14 as base-image
MAINTAINER Adam_Kovari
#Get wget tar
RUN apk add --no-cache wget tar
#Home dir
ARG USER_HOME_DIR="/root"
#create a dir for maven in opt
RUN mkdir /opt/maven
#Download maven
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz -O /tmp/maven.tar.gz
#Unzip
RUN cd /tmp && tar xvf maven.tar.gz
#Move to /opt/
RUN mv /tmp/* /opt/maven

#Install OpenJDK
RUN apk update && apk add --no-cache openjdk17 --repository=https://dl-cdn.alpinelinux.org/alpine/v3.17/community

#Setup JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk/
#Setup PATH
ENV PATH="$JAVA_HOME/bin:${PATH}"
#Setup MAVEN_HOME
ENV MAVEN_HOME=/opt/maven/apache-maven-3.9.1/
#Setup PATH
ENV PATH="$MAVEN_HOME/bin:${PATH}"
RUN export PATH

COPY src /qalev-report-app/src
COPY pom.xml /qalev-report-app

RUN mvn -e -f /qalev-report-app/pom.xml clean package -DskipTests


FROM alpine:3.14 as java-image
MAINTAINER Adam_Kovari
#Get wget tar
RUN apk add --no-cache wget tar
#Home dir
ARG USER_HOME_DIR="/root"
#create a dir for maven in opt
RUN mkdir /opt/maven
#Download maven
RUN wget https://dlcdn.apache.org/maven/maven-3/3.9.1/binaries/apache-maven-3.9.1-bin.tar.gz -O /tmp/maven.tar.gz
#Unzip
RUN cd /tmp && tar xvf maven.tar.gz
#Move to /opt/
RUN mv /tmp/* /opt/maven

#Install OpenJDK
RUN apk update && apk add --no-cache openjdk17 --repository=https://dl-cdn.alpinelinux.org/alpine/v3.17/community

#Setup JAVA_HOME
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk/
#Setup PATH
ENV PATH="$JAVA_HOME/bin:${PATH}"

COPY --from=base-image qalev-report-app/target/qalev-report-service-0.0.1-SNAPSHOT.jar /qalev-report-service/qalev-report-service-0.0.1-SNAPSHOT.jar
WORKDIR /qalev-report-service

EXPOSE 8080
ENTRYPOINT ["java","-jar","qalev-report-service-0.0.1-SNAPSHOT.jar"]
