# AltUnityTester Example Tests for iOS Build with Java Tests

This repository shows a few Java tests that use the page object model and AltUnityTester to test the Unity endless runner sample:
https://assetstore.unity.com/packages/essentials/tutorial-projects/endless-runner-sample-game-87901

### Running the tests on MacOS
The tests are meant to be run on a MacOS device. The Unity project is provided in the /AltTrashCat Unity iOS folder.
To build the XCode project, open the Unity project, and in the AltUnityTester window (Window -> AltUnityTester) run "Build Only".
To start the tests, run:
`./launch-iOS-game.sh`

This script will:

- clean build the app on your device
- run the tests
- stop the app after the test are done