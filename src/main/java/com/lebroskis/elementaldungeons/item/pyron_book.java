package com.lebroskis.elementaldungeons.item;

import com.lebroskis.elementaldungeons.entity.flameprojectile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class pyron_book extends Item {
    public pyron_book(Properties builder) {
        super(builder);
    }
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        worldIn.playSound((PlayerEntity) null, playerIn.getPosX(), playerIn.getPosY(), playerIn.getPosZ(), SoundEvents.ENTITY_BLAZE_SHOOT, SoundCategory.NEUTRAL, 0.5F, 0.4F /
                (random.nextFloat() * 0.4F + 0.8F));
        if (!worldIn.isRemote) {
            playerIn.getCooldownTracker().setCooldown(this, 80);
            flameprojectile flameprojectile = new flameprojectile(worldIn, playerIn, 0.0, -0.5, 0.0);
            flameprojectile.setDirectionAndMovement(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 1.5F, 2.0F);
            worldIn.addEntity(flameprojectile);
        }
        return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());
    }
}


