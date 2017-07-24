FROM tomcat:8.5.16
MAINTAINER Manglu Balasubramanian


#Copy the WAR file to the webapps directory
#This shoudl contain only one WAR file so the following command will not have any issue
COPY target/*.war /usr/local/tomcat/webapps/member-mgmt-services.war


