package ch.njol.unofficialmonumentamod.mixins;

import ch.njol.unofficialmonumentamod.UnofficialMonumentaModClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(DrawContext.class)
public abstract class DrawContextMixin {

	@ModifyVariable(method = "drawItem(Lnet/minecraft/item/ItemStack;II)V", at = @At("HEAD"), argsOnly = true)
	private ItemStack umm$editStack$drawItem(ItemStack value) {
		ItemStack edited = UnofficialMonumentaModClient.spoofer.apply(value);
		return edited != null ? edited : value;
	}

	@ModifyVariable(method = "drawItemWithoutEntity", at = @At("HEAD"), argsOnly = true)
	private ItemStack umm$editStack$drawItemWithoutEntity(ItemStack value) {
		ItemStack edited = UnofficialMonumentaModClient.spoofer.apply(value);
		return edited != null ? edited : value;
	}
}
