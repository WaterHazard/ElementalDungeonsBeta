package com.lebroskis.elementaldungeons.item;

import com.lebroskis.elementaldungeons.block.modblocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

public class ModItemGroup {
    public static final ItemGroup ELEMENTAL_DUNGEONS_GROUP = new ItemGroup( "ElementalDungeonsTab") {
        @Override
        public ItemStack createIcon( ) {
            return new ItemStack(ModItems.PYRON.get());
        }
    };
 public static final ItemGroup ELEMENTALDUNGEONSGROUP = new ItemGroup( "ElementalDungeonsTab2") {
     @Override
     public ItemStack createIcon() {
         return new ItemStack((IItemProvider) modblocks.PYRON_BLOCK.get());
     }
 };
}
