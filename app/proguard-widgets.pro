# Keep all widget classes
-keep public class * extends android.appwidget.AppWidgetProvider

# Keep widget update methods
-keepclassmembers class * extends android.appwidget.AppWidgetProvider {
    public void onUpdate(android.content.Context, android.appwidget.AppWidgetManager, int[]);
    public void onReceive(android.content.Context, android.content.Intent);
}

# Keep RemoteViews constructors
-keepclassmembers class * extends android.widget.RemoteViews {
    public <init>(android.content.Context, int);
}