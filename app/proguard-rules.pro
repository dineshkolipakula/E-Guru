# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-dontwarn org.xmlpull.v1.**
-keep class com.shockwave.**
-keep class org.xmlpull.v1.** { *;}
-dontwarn com.squareup.picasso.**
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-dontwarn org.xmlpull.v1.**
-keep class com.shockwave.**
-keep class org.xmlpull.v1.** { *;}
-keepattributes Signature
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-dontwarn okhttp3.**
-dontwarn okio.**
-keep class cz.msebera.android.httpclient.** { *; }
-keep class com.loopj.android.http.** { *; }

# Rome lib
-keep class com.rometools.** { *; }
-dontwarn java.beans.**
-dontwarn javax.**
-dontwarn org.jaxen.**
-dontwarn org.slf4j.**



# This rule will properly ProGuard all the model classes in
# the package com.yourcompany.models. Modify to fit the structure
# of your app.
-keepclassmembers class com.yourcompany.models.** {
  *;
}
