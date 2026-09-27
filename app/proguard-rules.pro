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

# Keep all widget-related classes
-keep class * extends android.appwidget.AppWidgetProvider { *; }
-keep class * extends android.widget.RemoteViewsService { *; }
-keep class * extends android.widget.RemoteViews { *; }

# Keep all resources
-keepclassmembers class **.R$* {
    public static <fields>;
}

# LitePal + model keep rules (prevent obfuscation/removal of LitePal runtime and model classes)
-keep class org.litepal.** { *; }

# Keep all classes that extend LitePalSupport (model classes), including their fields/methods.
-keep class * extends org.litepal.crud.LitePalSupport { *; }

# Keep all classes under com.syu.util package
-keep class com.syu.util.** { *; }

# Keep all annotations
-keepattributes *Annotation*

# Keep original class/method names so logs and stack traces are readable in release.
# Shrinking and optimization stay enabled; only renaming is turned off.
-dontobfuscate
# Keep line numbers and source file names in stack traces.
-keepattributes SourceFile,LineNumberTable

# FYT/SYU IPC: keep AIDL stubs, proxies and their callers intact.
# R8 inlining Stub.asInterface() into a caller from another package makes the caller
# instantiate the package-private Stub.Proxy directly, which ART rejects with IllegalAccessError.
-keep class com.syu.ipc.** { *; }
-keep class com.syu.remote.** { *; }

# Safety net for every other AIDL interface in the app and in the jars from libs/.
-keep class * implements android.os.IInterface { *; }

# Loaded by name via reflection in LauncherAppState (AppFilter class from resources).
-keep class com.syu.car.CustomFilter { <init>(...); }