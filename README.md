# Java Emergency API


[![Build Status](https://travis-ci.org/itjustworksteam/javaemergencyapi.svg?branch=master)](https://travis-ci.org/itjustworksteam/javaemergencyapi)

* Server Repo [here](https://github.com/itjustworksteam/emergencyserver.git)

# Install using Gradle

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
compile 'com.github.itjustworksteam:javaemergencyapi:0.0.1'
```