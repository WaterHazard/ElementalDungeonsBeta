package com.lebroskis.elementaldungeons.block;

import com.lebroskis.elementaldungeons.ElementalDungeons;
import com.lebroskis.elementaldungeons.item.ModItemGroup;
import com.lebroskis.elementaldungeons.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class modblocks {


    public static final DeferredRegister<Block> BLOCKS

            = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalDungeons.MOD_ID);
    public static final RegistryObject<Block> PURIFIER = RegisterBlock( "purifier",
            () -> new Purifier(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5,6)));

    public static final RegistryObject<Block> AQUEON_BLOCK = RegisterBlock("aqueon_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5,6)));

    public static final RegistryObject<Block> GEON_BLOCK = RegisterBlock("geon_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5,6)));

    public static final RegistryObject<Block> AERON_BLOCK = RegisterBlock("aeron_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON).harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5,6)));

    public static final RegistryObject<Block> PYRON_BLOCK = RegisterBlock( "pyron_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5,6)));



    private static <T extends Block>RegistryObject<T> RegisterBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
                return toReturn;


    }



    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS_.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModItemGroup.ELEMENTALDUNGEONSGROUP )));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
