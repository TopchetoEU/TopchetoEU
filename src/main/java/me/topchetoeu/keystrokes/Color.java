package me.topchetoeu.keystrokes;

public class Color {
    private float r, g, b, a;
    private int color;

    public float getRed() { return r; }
    public float getGreen() { return g; }
    public float getBlue() { return b; }
    public float getAlpha() { return a; }

    public void setRed(float val) { r = val; calculate(); }
    public void setGreen(float val) { g = val; calculate(); }
    public void setBlue(float val) { b = val; calculate(); }
    public void setAlpha(float val) { a = val; calculate(); }

    private int processChannel(float c) {
        int _c = (int)(c * 255);
        if (_c < 0) return 0;
        if (_c > 255) return 255;
        return _c;
    }

    private void calculate() {
        color = processChannel(a) << 24 |
                processChannel(r) << 16 |
                processChannel(g) << 8  |
                processChannel(b);
    }

    public int getColor() {
        return color;
    }

    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;

        calculate();
    }
    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 0;

        calculate();
    }

    private static float mix(float a, float b, float k) {
        return a * (1 - k) + b * k;
    }
    public static Color mix(Color a, Color b) {
        return new Color(
            (a.r + b.r) / 2,
            (a.g + b.g) / 2,
            (a.b + b.b) / 2,
            (a.a + b.a) / 2
        );
    }
    public static Color mix(Color a, Color b, float ratio) {
        if (ratio >= 0.999969) return b;
        if (ratio <= 0.000001) return a;
        return new Color(
            mix(a.r, b.r, ratio),
            mix(a.g, b.g, ratio),
            mix(a.b, b.b, ratio),
            mix(a.a, b.a, ratio)
        );
    }
}
