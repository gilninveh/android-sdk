# Pixoneye Android SDK
Pixoneye's SDK (Software Development Kit) is the on-device tool that allows the collection of data and the creation of recommendation, targeting and personalization - to be deployed on any app. Once installed, our SDK will provide data & analytic tools for understanding users’ behavior.

## Android SDK integration 


# Requirements
### Dependencies
* Dependencies 
Pixoneye SDK require depndencies, which will be added by gradle, exlude them if you use them in your project:

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
* In order to start Pixoneye, simply call:
```
Pixoneye.start(Context, <App_id>, <Api_key>, <User_id>);
```
App id and Api key are created when you create your app in [Pixoneye dashboard](https://dashboard.pixoneye.com/#/)
User id is the user in your system.

* Enable Pixoneye logs
Enabling Pixoneye logs is simple by using 
```
Pixoneye.setVerbose(true);
```
before starting pixoneye.

* target audience
Getting an item from the Pixoneye recomendation system
```
Pixoneye.getBestItem(Context <App_id>, <Api_key>, <AD_UNIT_ID>, onGetBestItemResult)
```
Getting multiple recomendations:
```
Pixoneye.getBestItems(Context <App_id>, <Api_key>, ArrayList<AD_UNIT_ID>, onGetBestItemsResult)
```
Returns a dictionary with AdUnitId to PixCampaign object
```
{adUnitID:String,
campaignID:String,
trackingID:String}
```
The campaginID is used to target the ad.

