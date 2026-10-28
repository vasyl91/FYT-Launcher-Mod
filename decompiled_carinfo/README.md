# decompiled_carinfo

The `com.syu.carinfo` package of FYT's canbus app, decompiled: the screens (activities) the app opens for the
settings of one car model each. It is **not part of the build** and the launcher does not load any of it.

It is kept for one purpose. In the launcher's settings, Fuel statistics shows the name of the class that serves
the car (`CanbusClasses.className()`, saved as `canbus_class`). That name leads to a file here, e.g.
`com.syu.carinfo.dasauto.DasAutoWcAct` is `com/syu/carinfo/dasauto/DasAutoWcAct.java`, for looking up the codes
the screen sends by hand.

The data classes the canbus callbacks share used to be here and are now in
`app/src/main/java/com/syu/module/canbus/data`.
