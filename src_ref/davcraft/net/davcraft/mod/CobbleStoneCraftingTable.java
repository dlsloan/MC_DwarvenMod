package net.davcraft.mod;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class CobbleStoneCraftingTable extends BlockContainer {
//TODO GUI!!!
    @SideOnly(Side.CLIENT)
    private IIcon iconTop;
    @SideOnly(Side.CLIENT)
    private IIcon iconFront;
    private static final String __OBFID = "CL_00000221";

    protected CobbleStoneCraftingTable(Material material)
    {
        super(material);
        
        this.setHardness(3.5f);
        this.setResistance(5.0f);
        this.setCreativeTab(DavCraft.davcraftTab);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.iconTop : (p_149691_1_ == 0 ? Blocks.cobblestone.getBlockTextureFromSide(p_149691_1_) : (p_149691_1_ != 2 && p_149691_1_ != 4 ? this.blockIcon : this.iconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
        this.iconTop = p_149651_1_.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_top");
        this.iconFront = p_149651_1_.registerIcon(DavCraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_front");
    }
    
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
    	super.onBlockAdded(world, x, y, z);
    	world.markBlockForUpdate(x, y, z);
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player,
			 int par6, float par7, float par8, float par9)
    {
		TileEntity te = world.getTileEntity(x, y, z);
		if(te == null || player.isSneaking())
		{	
			return false;
		}
		player.openGui(DavCraft.instance, 0, world, x, y, z);
		return true;
    }

	public void generateRecipe(Block material) {
		GameRegistry.addRecipe(new ItemStack(this, 1), new Object[] {
			"cc",
			"cc",
			'c', material
		});
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return null;
	}
}
