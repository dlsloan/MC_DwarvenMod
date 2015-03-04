package net.davcraft.mod.renderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import net.davcraft.mod.DavCraft;
import net.davcraft.mod.model.ModelStoneTorch;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

public class RenderStoneTorch extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(DavCraft.modid + ":" + "textures/blocks/StoneTorch.png");
	
	private ModelStoneTorch model;
	
	public RenderStoneTorch() {
		this.model = new ModelStoneTorch();
	}

	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float f) {
		boolean front = (entity.getBlockMetadata() & 4) != 0;
		boolean left = (entity.getBlockMetadata() & 1) != 0;
		boolean back = (entity.getBlockMetadata() & 8) != 0;
		boolean right = (entity.getBlockMetadata() & 2) != 0;
		
		GL11.glPushMatrix();
			GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
			GL11.glRotatef(180, 0f, 0f, 1f);
			this.bindTexture(texture);
			GL11.glPushMatrix();
				this.model.renderModel(0.0625f, front, back, left, right);
			GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
