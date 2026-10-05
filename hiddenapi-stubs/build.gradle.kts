// Compile-time stand-ins for the few hidden framework classes the app subclasses. The app depends
// on this module with compileOnly, so nothing here ends up in the APK: at runtime the real classes
// come from the device's framework. Only used with system privileges (see ForegroundAppTracker).
plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    // For the public types the stubs mention (ActivityManager.RunningTaskInfo, RemoteException).
    compileOnly(files("../android_jar/android-36.jar"))
}
