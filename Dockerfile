FROM tomcat:8.5.16
MAINTAINER Manglu Balasubramanian


#Copy the WAR file to the webapps directory
#This should contain only one WAR file so the following command will not have any issue

#In the local machine, the WAR file is under target directory. 
#Uncomment the line below to run this locally
#COPY target/*.war /usr/local/tomcat/webapps/member-mgmt-services.war

#In the DevOps pipeline, the directory is target. 
COPY *.war /usr/local/tomcat/webapps/member-mgmt-services.war


# Set password length and expiry for compliance with vulnerability advisor
RUN sed -i 's/ˆPASS_MAX_DAYS.*/PASS_MAX_DAYS   90/' /etc/login.defs
RUN sed -i 's/sha512/sha512 minlen=8/' /etc/pam.d/common-password

