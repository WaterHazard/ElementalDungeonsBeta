package com.lebroskis.elementaldungeons.tileentity;

import com.lebroskis.elementaldungeons.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public class PurifierTile extends TileEntity implements ITickableTileEntity {

    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public PurifierTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public PurifierTile(){
        this(ModTileEntities.PURIFIER_TILE.get());
    }


    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
         super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
         return super.write(compound);
    }

    public int counter = 120;
    @Override

    public void tick() {
        if(world.isRemote)
            return;

        if(canCraft()) {
            this.counter--;
            if(counter <= 0) {
                counter = 120;
                craft();
            }
        } else {
            counter = 120;
            markDirty();
        }
    }
    public int getCounter() {
        return this.counter;
    }
    public boolean canCraft() {
        AtomicBoolean toReturn = new AtomicBoolean(false);
        Inventory inv = new Inventory(itemHandler.getSlots());
        return itemHandler.getStackInSlot(1).getCount() > 0
                && this.itemHandler.getStackInSlot(1).getItem() == Items.IRON_INGOT &&
           itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == Items.WATER_BUCKET;

    }


        private ItemStackHandler createHandler() {
        return new ItemStackHandler(3) {
            @Override
            protected void onContentsChanged(int slot) {
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 1: return stack.getItem() == Items.IRON_INGOT;
                    case 2: return stack.getItem() == ModItems.CATALYST.get();
                    case 0: return stack.getItem() == Items.WATER_BUCKET ||
                            stack.getItem() == Items.BUCKET;

                    default:
                        return false;
                }
            }
              @Override
            public int getSlotLimit(int slot) {
                return 64;
              }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if (!isItemValid(slot, stack)) {
                    return stack;
                }
                 return super.insertItem(slot, stack, simulate);
            }
        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }

         return super.getCapability(cap, side);
    }
    public void craft() {
        boolean hasFocusInFirstSlot = this.itemHandler.getStackInSlot(1).getCount() > 0
                && this.itemHandler.getStackInSlot(1).getItem() == Items.IRON_INGOT;
        boolean hasIronInSecondSlot = this.itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == Items.WATER_BUCKET;

        if(hasFocusInFirstSlot && hasIronInSecondSlot) {
            this.itemHandler.getStackInSlot(1).shrink(1);
            this.itemHandler.getStackInSlot(0).shrink(1);

            this.itemHandler.insertItem(0, new ItemStack(Items.BUCKET), false);
            this.itemHandler.insertItem(2, new ItemStack(ModItems.CATALYST.get()), false);
        }

    }

}
