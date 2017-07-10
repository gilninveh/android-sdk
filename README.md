Pixoneye's SDK (Software Development Kit) is the on-device tool that allows the data and the creation of recommendation, targeting and personalization - to be deployed on any app. Once installed, our SDK will provide analytic tools and data about all users’ behavior.

## Android SDK integration 
*  Requirements
  1. Android Studio.
  2. Minimum android-api 14.
 
# Download
Download the latest AAR or grabe via Maven:
```
<dependency>
  <groupId>com.pixoneye</groupId>
  <artifactId>pixoneye-android-sdk</artifactId>
  <version>4.0.0</version>
  <type>pom</type>
</dependency>
```
or Gradle:
```
add to repositories:
repositories {
       maven {
            url  "http://dl.bintray.com/pixoneye/Android-SDK"
        }
    }
add to app dependencies:
dependencies {
  compile 'com.pixoneye:pixoneye-android-sdk:4.0.0@aar'
}
```
# Requirements
* Dependencies 
Pixoneye SDK require depndencies, Add the following to your app dependencies:
```
dependencies {
    compile 'com.google.code.gson:gson:2.7'
    compile 'com.squareup.retrofit2:retrofit:2.2.0'
    compile 'com.squareup.okhttp3:okhttp:3.7.0'
    compile 'com.squareup.retrofit2:converter-gson:2.2.0'
    compile 'com.google.android.gms:play-services-ads:11.0.1'
}
```

* Permissions
Pixoneye SDK require permissions, add the following to AndroidManifest:
```
  <uses-permission android:name="android.permission.WAKE_LOCK"/>
  <uses-permission android:name="android.permission.INTERNET"/>
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```
# ProGuard
When enabling proguard, proguard rules should be added. example can be found here:

[link here](https://s3-eu-west-1.amazonaws.com/pixoneyesdk/release/proguard-rules.pro)

