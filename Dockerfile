FROM tomcat:8.5.16
MAINTAINER Manglu Balasubramanian


#Copy the WAR file to the webapps directory
#This should contain only one WAR file so the following command will not have any issue

#In the local machine, the WAR file is under target directory. 
#Uncomment the line below to run this locally
#COPY target/*.war /usr/local/tomcat/webapps/member-mgmt-services.war

#In the DevOps pipeline, the directory is target. 
COPY *.war /usr/local/tomcat/webapps/member-mgmt-services.war


