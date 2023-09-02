FROM centos:7
ENV JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk \
    CATALINA_HOME=/opt/tomcat \
    PATH=$CATALINA_HOME/bin:$PATH
RUN yum -y update && \
    yum -y install java-1.8.0-openjdk-devel wget && \
    yum clean all
RUN yum -y install unzip
RUN wget https://dlcdn.apache.org/tomcat/tomcat-8/v8.5.93/bin/apache-tomcat-8.5.93.zip && \
    unzip apache-tomcat-8.5.93.zip -d /opt && \
    rm apache-tomcat-8.5.93.zip && \
    mv /opt/apache-tomcat-8.5.93 $CATALINA_HOME
RUN chmod +x $CATALINA_HOME/bin/catalina.sh
EXPOSE 8082
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
