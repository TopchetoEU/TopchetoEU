package me.topchetoeu.keystrokes.buttons;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import me.topchetoeu.keystrokes.Color;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.math.MatrixStack;

public class Button {
    public ButtonStyle style;
    public Position position;
    public Size size;
    public KeyBinding key;

    private float time = 0;
    private static Set<Button> buttons = new HashSet<>();

    public Color getColor(float tickDelta) {
        if (tickDelta != 0) {
            if (key.isPressed()) time = 0;
            else time += tickDelta / 20;
        }

        if (key.isPressed()) return style.active;
        return Color.mix(style.passive, style.active, style.fadeoff.calculate(time));
    }
    public Color getColor() {
        return getColor(0f);
    }
    public void register() {
        buttons.add(this);
    }
    public void unregister() {
        buttons.remove(this);
    }
    public void render(MatrixStack matrices, float tickDelta) {
        DrawableHelper.fill(matrices, position.x, position.y, size.width + position.x, size.height + position.y, getColor(tickDelta).getColor());
        TextRenderer renderer = MinecraftClient.getInstance().textRenderer;
        
        renderer.draw(
            matrices, "W",
            (size.width - renderer.getWidth("W")) / 2 + position.x,
            (size.height - renderer.fontHeight) / 2 + position.y,
            0xFFFFFF
        );
    }

    public static Set<Button> getRegisteredButtons() {
        return buttons.stream().collect(Collectors.toSet());
    }
}
