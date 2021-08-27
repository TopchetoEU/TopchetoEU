package me.topchetoeu.keystrokes;


import org.lwjgl.glfw.GLFW;

import me.topchetoeu.keystrokes.buttons.Button;
import me.topchetoeu.keystrokes.buttons.ButtonStyle;
import me.topchetoeu.keystrokes.buttons.Position;
import me.topchetoeu.keystrokes.buttons.Size;
import me.topchetoeu.keystrokes.buttons.fadeoffs.LinearFadeoff;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;

public class Keystrokes implements ModInitializer {
    @Override
    public void onInitialize() {
        ClientLifecycleEvents.CLIENT_STARTED.register(e -> {
            ButtonStyle style = new ButtonStyle(new LinearFadeoff(0.2f), new Color(0f, 0f, 0f, 0.5f), new Color(1f, 1f, 1f, 0.5f));

            Button button = new Button();
            button.key = KeyBindings.getByKey(GLFW.GLFW_KEY_W);
            button.position = new Position(0, 0);
            button.size = new Size(20, 20);
            button.style = style;
            button.register();
        });
    }
}
