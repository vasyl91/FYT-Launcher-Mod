// Code shared by the launcher and the VD host daemon (vdhost/server): the Binder protocol and the
// implementation of every host operation. The launcher runs VdHostCore in-process when it is
// installed as android.uid.system, and talks to the daemon over the same protocol otherwise.
//
// Plain Java against android.jar, like :hiddenapi-stubs, so the daemon can also be built with
// javac + d8 alone. Everything hidden is reached by reflection (see Hidden).
plugins {
    `java-library`
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

dependencies {
    compileOnly(files("../../android_jar/android-36.jar"))
}
