package net.davcraft.mod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.davcraft.mod.blocks.StoneTorch;
import net.davcraft.mod.blocks.TileEntityStoneTorch;
import net.davcraft.mod.renderer.RenderStoneTorch;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends CommonProxy {
	public void registerRenderThings() {
		TileEntitySpecialRenderer render = new RenderStoneTorch();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStoneTorch.class, render);
		//RenderingRegistry.registerEntityRenderingHandler(StoneTorch.class, render);
		//RenderingRegistry.registerBlockHandler(render);
		//ClientRegistry.
	}
	
	public void registerTileEntitySpecialRenderer() {
		
	}
}
