# Release 混淆规则

# 保留所有 AndroidManifest 中声明的四大组件（Service/Activity 等）
# R8 混淆类名会导致系统无法绑定，触发 "This service is malfunctioning"
-keep public class * extends android.accessibilityservice.AccessibilityService
-keep public class * extends android.app.Service
-keep public class * extends android.app.Activity
