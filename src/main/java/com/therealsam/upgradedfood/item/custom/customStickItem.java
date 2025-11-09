package com.therealsam.upgradedfood.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.OnAStickItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class customStickItem extends OnAStickItem<PigEntity> {
    public customStickItem(EntityType<PigEntity> target, int damagePerUse, Settings settings) {
        super(target, damagePerUse, settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity controllingPlayer, Hand hand) {
        ItemStack holding = controllingPlayer.getStackInHand(hand);
        if (controllingPlayer.getVehicle() instanceof PigEntity pig && pig.hasSaddleEquipped()) {
            if (pig.consumeOnAStickItem()) {
                holding.damage(7, controllingPlayer);
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }
}
