# ==============================
# STAGE 1: BUILD WAR
# ==============================

FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

# Kiểm tra PostgreSQL JDBC có thực sự nằm trong WAR
RUN jar tf /app/target/EmailList.war | grep "postgresql"

# ==============================
# STAGE 2: TOMCAT
# ==============================

FROM tomcat:9.0-jdk17-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=build \
    /app/target/EmailList.war \
    /usr/local/tomcat/webapps/EmailList.war

EXPOSE 8080

CMD ["catalina.sh", "run"]