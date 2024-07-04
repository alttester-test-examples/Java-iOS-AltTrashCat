# AltTester® Example Tests for iOS Build with Java Tests

This repository shows a few Java tests that use the page object model and AltTester® Unity SDK to test the Unity Endless Runner sample:
https://assetstore.unity.com/packages/essentials/tutorial-projects/endless-runner-sample-game-87901

### Before running the tests on iOS
- in the `BaseTest.java` class please change the value for `xcodeOrgId` with your Team ID (unique 10-character string) in the Apple dev account
- export `IOS_UDID=<your-device-udid>` then run the script `ios_tests.sh`
- considering that the IProxy does not have a way of setting up reverse port forwarding, to be able to connect it is necessary to follow the steps from https://alttester.com/docs/sdk/latest/pages/advanced-usage.html#in-case-of-ios

### Running the tests on MacOS
❗ Starting with version 2.0.0, the AltTester® Desktop must be running on your PC while the tests are running.

1. Download and install the AltTester® Desktop for MacOS from [here](https://alttester.com/downloads/), then open it.
2. The tests are meant to be run on an iOS device. Instrument the TrashCat application using the latest version of AltTester® Unity SDK - for additional information you can follow [this tutorial](https://alttester.com/walkthrough-tutorial-upgrading-trashcat-to-2-0-x/#Instrument%20TrashCat%20with%20AltTester%20Unity%20SDK%20v.2.0.x). The app needs to be included unzipped under the project.
3. To start the tests, run:
    ```
    `./ios_tests.sh`
    ```
This script will:

- clean build the app on your device
- run the tests
- stop the app after the tests are done
