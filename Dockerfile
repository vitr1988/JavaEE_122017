FROM oracle/glassfish:5.0

COPY target/JavaEE_122017-1.0-SNAPSHOT.war $GLASSFISH_HOME/glassfish/domains/domain1/autodeploy/JavaEE.war
