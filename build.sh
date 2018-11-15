#!/usr/bin/env sh

opts=""

case $1 in
    "build")
        mvn $opts -DskipTests clean package && rsync -av target/war-servlet-fast-start-0.1-SNAPSHOT/ /c/_commonShare/apache-tomcat-8.0.53/webapps/war-servlet-fast-start-0.1-SNAPSHOT/
    ;;
    "test")
        mvn $opts clean test
    ;;
    "clean")
        mvn $opts clean
    ;;
    "verify")
        mvn $opts -B verify
    ;;
    *) echo "Supply build|test|clean|verify"
    ;;
esac
