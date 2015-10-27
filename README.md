<p align="center">
  <img src="https://avatars0.githubusercontent.com/u/1316274?v=3&s=200">
</p>

TML Spring 3 Sample Application
==================

This sample application demonstrates how to use TML in Spring 3 environment.

Installation
==================

If you are using Maven, use the following procedures:

```bash
$ git clone https://github.com/translationexchange/tml-java-j2ee-spring3-samples-foody.git
```

Import the project into Eclipse using the Maven plugin:
  * Import Project as existing Maven Project
  * Browse to folder where you cloned the project and select presented pom.xml project file

Configure Tomcat server in Eclipse:
  * Select Server Tag and create new server
  * Select your prefered Tomcat server, click next
    * (optional) You can change Server name or leave it default,
  * All all Resources from Available tab to Configured within Resources window and click finish
  * By default Path is /tml-spring3-samples-foody, same as name of the applicaiton and artifactId
    * you can change it to anything you prefer under server Web Module settings

How to start sample app without Eclipse:
  * Download Tomcat and extract it to any folder
  * copy .war file from /Git Cloned Directory/target/tml-spring3-samples-foody-0.2.1.war to /Tomcat Path/webapps
  * start Tomcat:
    ```bash
    $ bin/startup.sh
    ```
  * by default .war get extracted under webapps and availble at http://localhost:8080/tml-spring3-samples-foody-0.2.1


For more information on Java TML check www.translationexchange.com/docs

Links
==================

* Register on TranslationExchange.com: https://translationexchange.com

* Follow TranslationExchange on Twitter: https://twitter.com/translationx

* Connect with TranslationExchange on Facebook: https://www.facebook.com/translationexchange

* If you have any questions or suggestions, contact us: support@translationexchange.com


Copyright and license
==================

Copyright (c) 2015 Translation Exchange, Inc.

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
