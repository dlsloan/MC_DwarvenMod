package com.dlsloan.dwarven.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import com.dlsloan.dwarven.Reference;

public class ModItems {
	public static Item iron_stick;
	
	public static void inti() {
		ModItems.iron_stick = new Item().setUnlocalizedName("iron_stick");
	}
	
	public static void register() {
		GameRegistry.registerItem(ModItems.iron_stick, ModItems.iron_stick.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders() {
		registerRender(ModItems.iron_stick);
	}
	
	public static void registerRender(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, 
				new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
