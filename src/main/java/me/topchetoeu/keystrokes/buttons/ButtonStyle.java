package me.topchetoeu.keystrokes.buttons;

import me.topchetoeu.keystrokes.Color;
import me.topchetoeu.keystrokes.buttons.fadeoffs.Fadeoff;

public class ButtonStyle {
    public Fadeoff fadeoff;
    public Color passive, active;

    public ButtonStyle(Fadeoff f, Color p, Color a) {
        fadeoff = f;
        passive = p;
        active = a;
    }
}
