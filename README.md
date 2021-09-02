# EspServer

Server to use for upgrading ESP8266 over the air. It only supports a GET stating which version is requested. It uploads the requested binary.


History

Version 1.2 - 02-09-2021
-  Upgraded for NetBeans 12.4 with Maven. Must be deployed on TomEE, not on plain TomCat!
-  Deleted obsolete Image Service (for old version of Switch software).

Version 1.1 - 01-05-2020
-  Added URI for ESP-IDF OTA function
-  Changed to Java11+ environment (no more JavaEE functions in standard JVM)

Version 1.0 - 25-07-2018
-  First version. Specific for switch software
