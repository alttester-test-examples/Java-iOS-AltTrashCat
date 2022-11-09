# AltTester Example Tests for iOS Build with Java Tests

This repository shows a few Java tests that use the page object model and AltTester Unity SDK to test the Unity endless runner sample:
https://assetstore.unity.com/packages/essentials/tutorial-projects/endless-runner-sample-game-87901

### Before running the tests on iOS
- in the `BaseTest.java` class please change the value for `xcodeOrgId` with your Team ID (unique 10-character string) in Apple dev account
- export `IOS_UDID=<your-device-udid>` then run the script `ios_tests.sh`

### Running the tests on MacOS
The tests are meant to be run on a MacOS device.
The app is provided at https://altom.com/app/uploads/AltTester/TrashCat/TrashCat.ipa.zip and needs to be included unzipped under project.
To start the tests, run:
`./ios_tests.sh`

This script will:

- clean build the app on your device
- run the tests
- stop the app after the test are done