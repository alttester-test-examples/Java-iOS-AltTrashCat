# AltTester Example Tests for iOS Build with Java Tests

This repository shows a few Java tests that use the page object model and AltTester Unity SDK to test the Unity endless runner sample:
https://assetstore.unity.com/packages/essentials/tutorial-projects/endless-runner-sample-game-87901

### Before running the tests on iOS
- in the `BaseTest.java` class please change the value for `xcodeOrgId` with your Team ID (unique 10-character string) in Apple dev account
- export `IOS_UDID=<your-device-udid>` then run the script `ios_tests.sh`
- considering that `port forwarding` is no longer available on iOS devices, to be able to use port forwarding it is necessary to follow the steps from https://alttester.com/docs/desktop/v.2.0.1/pages/known-issues.html#problem-with-reverse-port-forwarding-for-ios

### Running the tests on MacOS
❗ Starting with version 2.0.0, the AltTester Desktop must be running on your PC while the tests are running.

1. Install the [AltTesterDesktop](https://alttester.com/app/uploads/AltTester/desktop/AltTesterDesktopPackageMac__v2.0.1.zip), then open it.
2. The tests are meant to be run on an iOS device.The app is provided at https://altom.com/app/uploads/AltTester/TrashCat/TrashCat.ipa.zip and needs to be included unzipped under project.
3. To start the tests, run:
    ```
    `./ios_tests.sh`
    ```
This script will:

- clean build the app on your device
- run the tests
- stop the app after the test are done