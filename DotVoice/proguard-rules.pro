-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify
-verbose
-keepattributes Signature#保护泛型
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class com.android.vending.licensing.ILicensingService
-keepclasseswithmembernames class * {
 native <methods>;
}
-keepclasseswithmembers class * {
 public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
 public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers enum * {
 public static **[] values();
 public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable {
 public static final android.os.Parcelable$Creator *;
}

#-keep class com.tencent.**{*;}
-keep class org.webrtc.**{*;}




#-keep class com.neovisionaries.ws.client.**{*;}
#保留mode类
-keep class cc.dot.engine.mode.**{*;}
#保留入口类
#-keep class cc.dot.engine.**{*;}


-keep class cc.dot.engine.DotEngine{*;}
-keep class cc.dot.engine.Engine
-keep class cc.dot.engine.listener.**{*;}
-keep class cc.dot.engine.type.**{*;}
-keep class cc.dot.engine.utils.**{*;}




#-keep class org.google.**{*;}





# http://stackoverflow.com/questions/9120338/proguard-configuration-for-guava-with-obfuscation-and-optimization
-dontwarn javax.annotation.**
-dontwarn javax.inject.**
-dontwarn sun.misc.Unsafe


-keepattributes Signature


# Guava 19.0
-dontwarn java.lang.ClassValue
-dontwarn com.google.j2objc.annotations.Weak
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement