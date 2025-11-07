package com.therealsam.upgradedpigscarrots.mixin;

import com.therealsam.upgradedpigscarrots.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PigEntity.class)
public abstract class PigEntityMixin {

    @Inject(method = "initGoals", at = @At("TAIL"))
    private void addCustomTemptationGoal(CallbackInfo info) {
        PigEntity pig = (PigEntity)(Object)this;
        GoalSelector selector = ((EntityAccessorMixin)(Object)this).getGoalSelector();
        selector.add(4, new TemptGoal(pig, 1, stack -> stack.isOf(ModItems.ENCHANTED_GOLDEN_APPLE_ON_A_STICK), false));
        selector.add(4, new TemptGoal(pig, 1, stack -> stack.isOf(ModItems.NETHERITE_CARROT_ON_A_STICK), false));
        selector.add(4, new TemptGoal(pig, 1, stack -> stack.isOf(ModItems.NETHERITE_CARROT), false));
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
        boolean hasNetheriteCarrotStick = getMain.isOf(ModItems.NETHERITE_CARROT_ON_A_STICK) || getOff.isOf(ModItems.NETHERITE_CARROT_ON_A_STICK);

        if (hasCarrotStick || hasEnchantedAppleStick || hasNetheriteCarrotStick)
            cir.setReturnValue(player);
    }
}


