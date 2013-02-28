#!/bin/bash
ANDROID_HOME=/home/heron/eclipse
$ANDROID_HOME/platform-tools/adb shell monkey -p com.example.dojo1 -v 2000
/platform-tools/adb shell monkey -p com.example.dojo1 -v 20000
