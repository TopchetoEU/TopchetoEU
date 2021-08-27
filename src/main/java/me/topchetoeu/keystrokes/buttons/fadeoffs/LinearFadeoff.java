package me.topchetoeu.keystrokes.buttons.fadeoffs;

public class LinearFadeoff implements Fadeoff {
    private float duration;

    @Override public float getDuration() { return duration; }
    @Override public void setDuration(float val) { duration = val; }

    @Override
    public float calculate(float time) {
        if (time > duration) return 0;
        if (time < 0) return 1;
        return 1 - time / duration;
    }

    public LinearFadeoff(float duration) {
        this.duration = duration;
    }
}
