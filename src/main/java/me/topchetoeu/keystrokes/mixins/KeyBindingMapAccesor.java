package me.topchetoeu.keystrokes.mixins;

import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

@Mixin(KeyBinding.class)
public interface KeyBindingMapAccesor {
    @Final
    @Accessor("KEY_TO_BINDINGS")
    public static Map<InputUtil.Key, KeyBinding> get() { return null; }
}
