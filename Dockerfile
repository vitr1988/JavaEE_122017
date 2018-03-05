FROM tomcat:8.5.28-alpine

ENV JAVA_OPTS -Dfile.encoding=UTF8 -Duser.language=ru -Duser.region=RU -Djavax.xml.parsers.DocumentBuilderFactory=com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl -Djavax.xml.parsers.SAXParserFactory=com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl

# docker run -v /webapps/JavaEE.war:/usr/local/tomcat/webapps/JavaEE.war
COPY target/JavaEE_122017-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/JavaEE.war
# Copy configurations (Tomcat users, Manager app)
COPY conf/tomcat-users.xml /usr/local/tomcat/conf/
COPY conf/context.xml /usr/local/tomcat/webapps/manager/META-INF/

CMD ["catalina.sh", "run"]

