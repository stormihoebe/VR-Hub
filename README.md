# VR Hub

VR Hub is a social media platform for Virtual Reality/Augmented Reality/Mixed Reality enthusiasts, developers, and designers. 

## Details
This application is under active development and current features are changing daily. This app allows users to sign up
 for access to the app using an email address and password. The App allows users to post messages on a community message board 
  that utilizes a firebase database. The App also uses the Twitter API to display tweets with #VirtualReality and users have the 
  ability to search for other keywords under #VirtualReality.

## Installation
* `git clone <https://github.com/stormihoebe/VR-Hub.git>`
* Open VR-Hub directory in Android Studio
* Follow any prompts to clean project of unfound files.

## API Credentials
* Navigate to <https://apps.twitter.com/app/new> in browser
* Log in to Twitter (if necessary)
* Fill out Application Details form (dummy text is acceptable, name must be unique)
* Select `Create your Twitter application` button to submit form
* Navigate to `Keys and Access Tokens`
* Select `Create my access token` button to generate access token.
* You will see your Consumer Key (API Key), Consumer Secret (API Secret) at the top of the page, and your Access Token and Access Token Secret at the bottom of the page. You will need all of these values to make a proper API call.

## Adding API Credentials to App
* Open VR-Hub in Android Studio, navigate to root directory.
* Create file in root directory named gradle.properties (this file is included in the .ignore file)
* Add API Credentials to gradle.properties
* Your gradle.properties should look like this (replacing the X with your credentials, of course):

```
TwitterConsumerKey = "XXXXXXXXXXXXXXXXX"
TwitterConsumerSecret = "XXXXXXXXXXXXXXXXXXX"
TwitterToken = "XXXXXXXXXXXXXXXXX"
TwitterTokenSecret = "XXXXXXXXXXXXXXXXXXXXXXXXXX"
```
* Sync gradle to prepare to run

## Running
* Follow the APU Credentials steps above.
* Run 'app' on Android Emulator
* Sign up for an account with a valid email address and 6+ digit password. 

 

## Current Bugs
* Login/Join: User is currently prompted to sign in/ join regardless if the device is already signed into the account. Clicking 
either login or join will lead the user to the landing page if they are already signed on. 
* App does not record author to messages when they are posted at this time. 



### Useful Links


### Support and contact details

Contact Stormi at Epicodus
stormihoebe@gmail.com

### License

Copyright (c) 2017 **_MIT License_**
