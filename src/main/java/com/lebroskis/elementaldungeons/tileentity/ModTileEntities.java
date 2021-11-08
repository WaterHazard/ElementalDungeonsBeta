package com.lebroskis.elementaldungeons.tileentity;

import com.lebroskis.elementaldungeons.ElementalDungeons;
import com.lebroskis.elementaldungeons.block.modblocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ElementalDungeons.MOD_ID);
    public static RegistryObject<TileEntityType<PurifierTile>> PURIFIER_TILE =
            TILE_ENTITIES.register("purifier_tile", () -> TileEntityType.Builder.create(
                    PurifierTile::new, modblocks.PURIFIER.get()).build( null)) ;
    public static void  register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
