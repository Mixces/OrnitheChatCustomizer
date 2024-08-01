package me.mixces.gui_customizer.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.gui.chat.ChatGui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ChatGui.class)
public abstract class ChatGuiMixin {

	@WrapWithCondition(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/client/gui/chat/ChatGui;fill(IIIII)V",
			ordinal = 0
		)
	)
    private boolean guiCustomizer$removeBackground(int x1, int y1, int x2, int y2, int color) {
		return false;
	}

	@ModifyArg(
		method = "render",
		at = @At(
			value = "INVOKE",
			target = "Lcom/mojang/blaze3d/platform/GlStateManager;translatef(FFF)V",
			ordinal = 0
		),
		index = 1
	)
	private float guiCustomizer$adjustChatHeight(float x) {
		return x - 12;
	}
}
