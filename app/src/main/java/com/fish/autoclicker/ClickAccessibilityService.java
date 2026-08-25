package com.fish.autoclicker;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.view.accessibility.AccessibilityEvent;

public class ClickAccessibilityService extends AccessibilityService {

    private static ClickAccessibilityService instance;

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        instance = this;
    }

    public static ClickAccessibilityService getInstance() {
        return instance;
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {}

    @Override
    public void onInterrupt() {}

    // Ejecuta un clic rápido o un mantenimiento presionado (Hold)
    public void performClickOrHold(int x, int y, long durationMs) {
        Path path = new Path();
        path.moveTo(x, y);

        GestureDescription.StrokeDescription stroke = 
                new GestureDescription.StrokeDescription(path, 0, durationMs);

        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(stroke);

        dispatchGesture(builder.build(), null, null);
    }
}