FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD add-envelope-0.0.1.jar testapp.jar
RUN sh -c 'touch /testapp.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /testapp.jar" ]