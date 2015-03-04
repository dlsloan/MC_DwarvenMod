package net.davcraft.mod.items.tools;

import net.davcraft.mod.DavCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IronPunch extends Item {

	public IronPunch() {
		super();
		this.maxStackSize = 1;
		this.setMaxDamage(10); //uses before break
		this.setNoRepair();
		this.setCreativeTab(DavCraft.davcraftTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	public void generateRecipe(Object material) {
		GameRegistry.addShapelessRecipe(new ItemStack(this, 1), new Object[] {material});
	}
	
}
