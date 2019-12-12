# 基础镜像：openjdk:8-jdk-alpine
FROM openjdk:8-jdk-alpine
# 挂载目录，默认的安装jar包位置：/tmp
VOLUME /tmp
COPY target/fastjson-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]