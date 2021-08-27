package me.topchetoeu.keystrokes.buttons.fadeoffs;

public interface Fadeoff {
    float getDuration();
    void setDuration(float val);

    float calculate(float time);
}
