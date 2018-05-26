#!/bin/bash

cd /home/dev/git/Venus
mvnDebug clean install tomcat7:run-war
