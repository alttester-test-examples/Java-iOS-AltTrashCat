#!/bin/bash

#########################################################
#
# Preparing to start Appium
# - UDID is the device ID on which test will run and
#   required parameter on iOS test runs
# - appium - is a wrapper tha calls the latest installed
#   Appium server. Additional parameters can be passed
#   to the server here.
#
#########################################################

echo "UDID set to ${IOS_UDID}"
echo "Starting Appium ..."
appium > appium.log 2>&1 &
sleep 10
ps -ef|grep appium

## Desired capabilities
export APP=$PWD/TrashCat_2.0.1_172.20.10.2.ipa
export UDID="c41292b241767c59fcd07016b432b1e7c2223cfd"
## Clean local screenshots directory:
rm -rf screenshots

## Run the tests:
echo "Running tests"
cd "/src"
mvn test

echo "Tests done"

echo "---> Killing existing xcode processes:"
killall xcodebuild || true
