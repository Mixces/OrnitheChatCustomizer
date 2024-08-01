package me.mixces.gui_customizer.mixin;

import net.minecraft.client.gui.screen.inventory.menu.InventoryMenuScreen;
import net.minecraft.client.gui.screen.inventory.menu.PlayerInventoryScreen;
import net.minecraft.inventory.menu.InventoryMenu;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerInventoryScreen.class)
public abstract class PlayerInventoryScreenMixin extends InventoryMenuScreen {

	public PlayerInventoryScreenMixin(InventoryMenu menu) {
		super(menu);
	}

	@Inject(
		method = "checkStatusEffects",
		at = @At(
			value = "FIELD",
			opcode = Opcodes.PUTFIELD,
			target = "Lnet/minecraft/client/gui/screen/inventory/menu/PlayerInventoryScreen;x:I",
			ordinal = 0,
			shift = At.Shift.AFTER
		)
	)
	private void guiCustomizer$removePotionOffset(CallbackInfo ci) {
		x = (width - backgroundWidth) / 2;
	}
}
