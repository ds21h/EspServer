# EspServer

Server to use for upgrading ESP8266 over the air. It only supports a GET stating which binary and which version is requested. It uploads the requested binary.
The HEAD that the ESP8266 upgrade function issues is handled completely by TomCat. This however creates the issue that TomCat calls the GET and than determines how much data is sent in order to make the HTTP Content-Length header. TomCat sends that as chunked. As the result hereoff the Content-Length provided in the HEAD is the total length, so including the chunked overhead. The ESP8266 upgrade function however uses this length as the nett length of the data. In order to overcome this the GET adds the Content-Length header programmatically, so Tomcat knows how much data to send. As the result hereoff the data is sent normally (so not chunked).
The OTA function of ESP-IDF is somewhat more intelligent so the extra addendum for Content-Length is not necessary.

History

Version 1.1 - 01-05-2020
-  Addid URI for ESP-IDF OTA function
-  Changed to Java11+ environment (no more JavaEE functions in standard JVM)

Version 1.0 - 25-07-2018
-  First version. Specific for switch software
