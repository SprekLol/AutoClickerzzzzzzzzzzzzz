package com.fish.autoclicker;

import android.os.Handler;
import android.os.Looper;

public class ClickController {

    private boolean isRunning = false;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private ClickConfig config;

    public ClickController(ClickConfig config) {
        this.config = config;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        if (isRunning) return;
        isRunning = true;
        runAction();
    }

    public void stop() {
        isRunning = false;
        handler.removeCallbacksAndMessages(null);
    }

    private void runAction() {
        if (!isRunning) return;

        ClickAccessibilityService service = ClickAccessibilityService.getInstance();
        if (service == null) return;

        if (config.getMode() == ClickConfig.Mode.HOLD) {
            // Modo Hold: Mantiene presionada la pantalla en (X, Y)
            service.performClickOrHold(config.getX(), config.getY(), config.getHoldDurationMs());
            
            // Repite el hold si sigue encendido tras cumplir la duración
            handler.postDelayed(this::runAction, config.getHoldDurationMs() + 50);
        } else {
            // Modo Clic Normal
            service.performClickOrHold(config.getX(), config.getY(), 50);
            handler.postDelayed(this::runAction, config.getIntervalMs());
        }
    }
}