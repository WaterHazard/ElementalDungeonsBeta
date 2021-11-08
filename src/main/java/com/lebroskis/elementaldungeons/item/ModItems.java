package com.lebroskis.elementaldungeons.item;

import com.lebroskis.elementaldungeons.ElementalDungeons;
import net.minecraft.data.BlockModelDefinition;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS_ =
            DeferredRegister.create(ForgeRegistries.ITEMS, ElementalDungeons.MOD_ID);

    public static final RegistryObject<Item> PYRON = ITEMS_.register( "pyron",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final RegistryObject<Item> CATALYST = ITEMS_.register("catalyst",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  AERON = ITEMS_.register( "aeron",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  AQUEON = ITEMS_.register( "aqueon",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  GEON = ITEMS_.register( "geon",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final RegistryObject<Item> PLASMAENERGY = ITEMS_.register("plasmaenergy",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  GASENERGY = ITEMS_.register( "gasenergy",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  LIQUIDENERGY = ITEMS_.register( "liquidenergy",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  SOLIDENERGY = ITEMS_.register( "solidenergy",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static final  RegistryObject<Item>  ELEMENTAL_BOOK = ITEMS_.register( "elemental_book",
            () -> new Item(new Item.Properties() .group(ModItemGroup.ELEMENTAL_DUNGEONS_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS_.register(eventBus);
    }
}
