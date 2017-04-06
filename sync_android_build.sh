# !/bin/bash



DIR="$( pwd )"


scplib(){
    scp  -r root@hongkong://root/webrtc-android/android/webrtc/libjingle_peerconnection_builds/Release /tmp/
}


cplib(){

    cp /tmp/Release/jni/arm/*.so  $DIR/DotEngine/jni/armeabi-v7a/
    echo "cp arm done"
    cp /tmp/Release/jni/arm64/*.so  $DIR/DotEngine/jni/arm64-v8a/
    echo "cp arm64 done"
    cp /tmp/Release/jni/x86/*.so  $DIR/DotEngine/jni/x86/
    echo "cp x86 done"
    cp /tmp/Release/jni/x64/*.so  $DIR/DotEngine/jni/x86_64/
    echo "cp x84 done"
    cp -rf /tmp/Release/libs/org  $DIR/DotEngine/src/main/java/
    echo "cp  lib org.webrtc done"
}
