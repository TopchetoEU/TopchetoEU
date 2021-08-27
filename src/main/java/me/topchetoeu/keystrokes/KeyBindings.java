package me.topchetoeu.keystrokes;

import java.util.Collection;

import me.topchetoeu.keystrokes.mixins.KeyBindingMapAccesor;
import net.minecraft.client.option.KeyBinding;

public class KeyBindings {
    public static Collection<KeyBinding> getAll() {
        return KeyBindingMapAccesor.get().values();
    }
    public static KeyBinding getByKey(int n) {
        return getAll().stream().filter(v -> v.getDefaultKey().getCode() == n).findFirst().get();
    }
}
