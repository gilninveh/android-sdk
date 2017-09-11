# Pixoneye Android SDK
Pixoneye's SDK (Software Development Kit) is the on-device tool that allows the data and the creation of recommendation, targeting and personalization - to be deployed on any app. Once installed, our SDK will provide analytic tools and data about all users’ behavior.

## Android SDK integration 
###  Requirements
  1. Android Studio.
  2. Minimum android-api 16.
 
# Download
Download the [latest AAR](https://bintray.com/pixoneye/Android-SDK/download_file?file_path=com%2Fpixoneye%2Fpixoneye-android-sdk%2F4.0.2%2Fpixoneye-android-sdk-4.0.2.aar) or grabe via Maven:
```
<dependency>
  <groupId>com.pixoneye</groupId>
  <artifactId>pixoneye-android-sdk</artifactId>
  <version>4.0.2</version>
  <type>pom</type>
</dependency>
```
Or Gradle:

Add to repositories at project level
```
repositories {
       maven {
            url  "http://dl.bintray.com/pixoneye/Android-SDK"
        }
    }
```
Add to dependencies at app level
```
dependencies {
  compile 'com.pixoneye:pixoneye-android-sdk:4.0.2'
}
```

# Requirements
* Dependencies 
Pixoneye SDK require depndencies, which will be added by gradle, exlude them if you use them in your project:
 
### Dependencies

```
dependencies {
    compile 'com.google.code.gson:gson:2.7'
    compile 'com.squareup.retrofit2:retrofit:2.2.0'
    compile 'com.squareup.okhttp3:okhttp:3.7.0'
    compile 'com.squareup.retrofit2:converter-gson:2.2.0'
    compile 'com.google.android.gms:play-services-ads:11.0.1'
}
```

### Permissions
Pixoneye SDK require permissions, add the following to AndroidManifest:
```
  <uses-permission android:name="android.permission.WAKE_LOCK"/>
  <uses-permission android:name="android.permission.INTERNET"/>
  <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
```
### ProGuard
When enabling proguard, proguard rules should be added. example can be found [here](https://github.com/pixoneye/android-sdk/blob/master/PixoneyeIntegrationSample/app/pixoneye-sdk-proguard-rules.pro)

## Usage
In order to start Pixoneye simply:
```
Pixoneye.start(Context, <App_id>, <Api_key>, <User_id>);
```
App id and Api key created when you create your add in [Pixoneye dashboard](https://dashboard.pixoneye.com/#/)
User id is the user in your system.

for more details check the sample project. [Sample project](https://github.com/pixoneye/android-sdk/tree/master/PixoneyeIntegrationSample)
