FROM registry.thunisoft.com:5000/thunisoft/java:server-jre-8u201-in-centos-7.6.1810
#维护者
MAINTAINER xuzhou@thunisoft.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone
EXPOSE 8080
ADD ygkq.jar app.jar
VOLUME ["/home/logs/ygkq"]
ENV LOGLEVEL="error" PARAMS="-XX:MaxRAMPercentage=85.0 -XX:MinRAMPercentage=50.0" LOGHOME="/home/logs/ygkq"
ENTRYPOINT ["sh", "-c", "java $PARAMS  -Djava.security.egd=file:/dev/./urandom -jar app.jar --log.home=$LOGHOME --logback.root.level=$LOGLEVEL"]