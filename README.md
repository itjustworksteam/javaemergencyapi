# Java Emergency API


[![Build Status](https://travis-ci.org/itjustworksteam/javaemergencyapi.svg?branch=master)](https://travis-ci.org/itjustworksteam/javaemergencyapi)

* Server Repo [here](https://github.com/itjustworksteam/emergencyserver.git)

## Install using Gradle

This repo does not use standard repos, so use JitPack.

* First in your root build.gradle file add this:

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

* finally in your dependencies add:

```
compile 'com.github.itjustworksteam:javaemergencyapi:0.0.3'
```

## Using it

* get the json response

```
String response = new Emergency().sendRequest(new Numbers(Numbers.LATITUDE_LONGITUDE, "45.0", "9.0"));
// response is a Json String like this : {"name":"Italy", "code":"IT", "police":"113", "medical":"118", "fire":"115", "closestcity":"Voghera"}
``` 

* parse the json response

```
Country country = Country.parse(response);   // response is the string before
assertEquals("Italy", country.name());
assertEquals("IT", country.code());
assertEquals("113", country.police());
assertEquals("118", country.medical());
assertEquals("115", country.fire());
assertEquals("Voghera", country.city());
```
 
