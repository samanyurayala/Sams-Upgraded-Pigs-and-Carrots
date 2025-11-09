package com.therealsam.upgradedfood.mixin;

import com.therealsam.upgradedfood.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SaddledComponent;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Objects;

@Mixin(PigEntity.class)
public abstract class PigEntityMixin {

    @Shadow private SaddledComponent saddledComponent;

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void addCustomTemptationGoal(CallbackInfo info) {
        PigEntity pig = (PigEntity)(Object)this;
        GoalSelector selector = ((EntityAccessorMixin)(Object)this).getGoalSelector();
        selector.add(4, new TemptGoal(pig, 1.2, stack -> stack.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK), false));
        selector.add(4, new TemptGoal(pig, 1.1, stack -> stack.isOf(ModItems.CARROTS_ON_A_STICK), false));
        selector.add(4, new TemptGoal(pig, 1.1, stack -> stack.isOf(ModItems.NETHERITE_CARROT), false));
    }

    @Inject(method = "getControllingPassenger", at = @At("HEAD"), cancellable = true)
    private void allowCustomStick(CallbackInfoReturnable<LivingEntity> cir) {
        PigEntity pig = (PigEntity)(Object)this;
        if (!pig.hasSaddleEquipped()) return;
        if (!(pig.getFirstPassenger() instanceof PlayerEntity player)) return;

        ItemStack getMain = player.getMainHandStack();
        ItemStack getOff = player.getOffHandStack();

        boolean hasCarrotStick = getMain.isOf(Items.CARROT_ON_A_STICK) || getOff.isOf(Items.CARROT_ON_A_STICK);
        boolean hasEnchantedAppleStick = getMain.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK) || getOff.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
        boolean hasCarrotsStick = getMain.isOf(ModItems.CARROTS_ON_A_STICK) || getOff.isOf(ModItems.CARROTS_ON_A_STICK);

        if (hasCarrotStick || hasEnchantedAppleStick || hasCarrotsStick)
            cir.setReturnValue(player);
    }

    @Inject(method = "getSaddledSpeed", at = @At("HEAD"), cancellable = true)
    private void customSpeed(PlayerEntity controllingPlayer, CallbackInfoReturnable<Float> cir) {
        PigEntity pig = (PigEntity)(Object)this;

        ItemStack getMain = controllingPlayer.getMainHandStack();
        ItemStack getOff = controllingPlayer.getOffHandStack();

        boolean hasEnchantedAppleStick = getMain.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK) || getOff.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
        boolean hasCarrotsStick = getMain.isOf(ModItems.CARROTS_ON_A_STICK) || getOff.isOf(ModItems.CARROTS_ON_A_STICK);

        double baseSpeed = pig.getAttributeValue(EntityAttributes.MOVEMENT_SPEED) * 0.225 * saddledComponent.getMovementSpeedMultiplier();

        if (hasEnchantedAppleStick) {
            cir.setReturnValue((float)(baseSpeed * 5));
        } else if (hasCarrotsStick) {
            cir.setReturnValue((float)(baseSpeed * 30));
        } else {
            cir.setReturnValue((float)(baseSpeed));
        }
    }

    @Inject(method = "tickControlled", at = @At("HEAD"))
    private void customControl(PlayerEntity controllingPlayer, Vec3d movementInput, CallbackInfo info) {
        PigEntity pig = (PigEntity)(Object)this;

        ItemStack getMain = controllingPlayer.getMainHandStack();
        ItemStack getOff = controllingPlayer.getOffHandStack();

        boolean hasEnchantedAppleStick = getMain.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK) || getOff.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK);
        boolean hasCarrotsStick = getMain.isOf(ModItems.CARROTS_ON_A_STICK) || getOff.isOf(ModItems.CARROTS_ON_A_STICK);

        double baseHealth = 10;
        EntityAttributeInstance health = Objects.requireNonNull(pig.getAttributeInstance(EntityAttributes.MAX_HEALTH));
        float currentHealth = pig.getHealth();
        float getMaxHealth = (float)(pig.getAttributeValue(EntityAttributes.MAX_HEALTH));

        if (hasEnchantedAppleStick) {
            health.setBaseValue(baseHealth * 3);
            pig.setHealth((float)(baseHealth * 3 + currentHealth - getMaxHealth));
        } else if (hasCarrotsStick) {
            health.setBaseValue(baseHealth * 2);
            pig.setHealth((float)(baseHealth * 2 + currentHealth - getMaxHealth));
            pig.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20, 1, true, false));
        } else {
            health.setBaseValue(baseHealth);
            pig.setHealth((float)(baseHealth + currentHealth - getMaxHealth));
        }

    }
}


