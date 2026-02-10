package com.liandian.app.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.view.accessibility.AccessibilityEvent

class ClickAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        try {
            // 动态配置：不订阅任何事件，仅保留手势派发能力
            serviceInfo = (serviceInfo ?: AccessibilityServiceInfo()).apply {
                eventTypes = 0
            }
        } catch (_: Exception) {
        }
        GestureBridge.accessibilityService = this
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // 不需要处理无障碍事件，仅用于手势派发
    }

    override fun onInterrupt() {
    }

    override fun onDestroy() {
        super.onDestroy()
        GestureBridge.accessibilityService = null
    }
}
