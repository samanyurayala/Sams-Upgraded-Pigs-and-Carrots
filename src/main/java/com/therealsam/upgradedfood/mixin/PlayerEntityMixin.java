package com.therealsam.upgradedfood.mixin;

import com.therealsam.upgradedfood.TrackPlayerJump;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(ClientPlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "tickMovement", at = @At("TAIL"))
    public void onJump(CallbackInfo info) {
        ClientPlayerEntity player = (ClientPlayerEntity)(Object)(this);
        com.therealsam.upgradedfood.TrackPlayerJump.setJump(player.input.playerInput.jump());
    }
}
