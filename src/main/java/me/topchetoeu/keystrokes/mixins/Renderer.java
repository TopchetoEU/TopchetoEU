package me.topchetoeu.keystrokes.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.topchetoeu.keystrokes.buttons.Button;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;

@Mixin(InGameHud.class)
public class Renderer {
	@Inject(at = @At("TAIL"), method = "render")
	public void renderKeystrokesHud(MatrixStack matrices, float tickDelta, CallbackInfo info) {
		Button.getRegisteredButtons().forEach(v -> v.render(matrices, tickDelta));
	}
}
