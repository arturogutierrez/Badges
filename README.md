Badges
======

Small library to show badges in app icons for unread messages on most common manufacturers: LG, Sony, Samsung and HTC.

Screenshots
-----------

LG<br/>
![Demo Screenshot 1][1]

Sony<br/>
![Demo Screenshot 2][2]

Samsung<br/>
![Demo Screenshot 4][3]

HTC<br/>
![Demo Screenshot 3][4]


Usage
-----------
```java
  try {
      Badges.setBadge(context, 5);
  } catch (BadgesNotSupportedException badgesNotSupportedException) {
      Log.d(TAG, badgesNotSupportedException.getMessage());
  }
```


Download
-----------
The library will be available on Maven and Gradle repository, meanwhile you can clone the project and add it to your project as library.


Supported Launchers
-----------

* LG
* Sony
* Samsung
* HTC

Developed By
------------

* Arturo Gutiérrez Díaz-Guerra - <arturo.gutierrez@gmail.com>

<a href="https://twitter.com/morpheo17">
  <img alt="Follow me on Twitter" src="http://imageshack.us/a/img812/3923/smallth.png" />
</a>
<a href="http://www.linkedin.com/in/arturogutierrezdiazguerra">
  <img alt="Add me to Linkedin" src="http://imageshack.us/a/img41/7877/smallld.png" />
</a>

License
-------

    Copyright 2014 Arturo Gutiérrez Díaz-Guerra

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


[1]: ./art/example_lg.png
[2]: ./art/example_sony.png
[3]: ./art/example_samsung.png
[4]: ./art/example_htc.png
