This script can be used to undeploy the revisions which are deployed in a proxy for an environment

----
Instructions for execution
----
-download the jar file
-In command prompt traverse to the specific path of downloaded jar
-run $java -jar UndeployRevision.jar username password protocol domain org environment filepath 

----
Description: Arguments being passed in above command
----
-username and password -> credentials used for apigee login 
-protocol -> https/http
-domain name -> api.enterprise.apigee.com for saas, if on prem provide the on prem domain name
-org -> organization for which the undeployment as to be done
-environment -> the environment for which the undeployment must be done
-filepath -> this is the path of the file which contains the list of proxy names for which we have to undeploy the proxy revision. Specify full path for the file. 
          for example: C:\Users\...\Desktop\proxylist.txt
          This file must have one proxyname per line.  
          A sample file contents is as shown below. 
          -----
          proxyname1
          proxyname2
          proxyname3
          .
          .
          .
          proxyname100
          ----
