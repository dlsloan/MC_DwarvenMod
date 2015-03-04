package net.davcraft.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.davcraft.mod.DavCraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class CopperBlock extends Block {
	
	public CopperBlock(Material material) {
		super(material);
		
		this.setHardness(3f);
		this.setResistance(5f);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(getCreativeTabToDisplayOn().tabBlock);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5)); //remove "tile."
	}
}
