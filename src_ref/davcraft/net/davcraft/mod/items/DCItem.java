package net.davcraft.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.davcraft.mod.DavCraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class DCItem extends Item {

	public DCItem() {
		this.setCreativeTab(DavCraft.davcraftTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5));  //substring(5) removes "item."
	}
}
