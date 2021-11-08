package com.lebroskis.elementaldungeons.screen;

import com.lebroskis.elementaldungeons.ElementalDungeons;
import com.lebroskis.elementaldungeons.container.PurifierContainer;
import com.lebroskis.elementaldungeons.tileentity.PurifierTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class PurifierScreen extends ContainerScreen<PurifierContainer> {
    private final ResourceLocation GUI = new ResourceLocation(ElementalDungeons.MOD_ID,
            "textures/screen/purifier_gui.png");

    public PurifierScreen(PurifierContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }






    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);

    }


    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0, 0, this.xSize, this.ySize);

        if (this.container.canCraft()) {
            int k = this.container.getCounter()/6;
            this.blit(matrixStack, i + 60, j + 19 + 12,
                    176, 1, 57, k + 1);
        }
    }


}



