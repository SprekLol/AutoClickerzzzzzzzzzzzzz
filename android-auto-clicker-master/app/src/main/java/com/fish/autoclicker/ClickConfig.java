package com.fish.autoclicker;

public class ClickConfig {
    public enum Mode {
        INTERVAL, // Clics continuos por intervalo
        HOLD      // Mantener presionado (Long Press)
    }

    private Mode mode = Mode.INTERVAL;
    private int x = 500; // Coordenada X por defecto
    private int y = 1000; // Coordenada Y por defecto
    private int intervalMs = 100; // Para modo INTERVAL
    private int holdDurationMs = 3000; // Duración del Hold en milisegundos

    // Getters y Setters
    public Mode getMode() { return mode; }
    public void setMode(Mode mode) { this.mode = mode; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getIntervalMs() { return intervalMs; }
    public void setIntervalMs(int intervalMs) { this.intervalMs = intervalMs; }

    public int getHoldDurationMs() { return holdDurationMs; }
    public void setHoldDurationMs(int holdDurationMs) { this.holdDurationMs = holdDurationMs; }
}