package net.davcraft.mod.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.davcraft.mod.DavCraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class StoneTorch extends BlockContainer {
	public StoneTorch() {
		super(Material.circuits);
		this.setTickRandomly(true);
		this.setCreativeTab(DavCraft.davcraftTab);
		this.setLightOpacity(0);
		this.lightValue = 14;
		this.setBlockTextureName("StoneTorch");
		this.setBlockBounds(6f/16f, 0f, 6f/16f, 10f/16f, 12f/16f, 10f/16f);
	}

	public void generateRecipe(Object material, Object fuel) {
		GameRegistry.addRecipe(new ItemStack(this, 4), new Object[] {
			"pf",
			" m",
			'p', new ItemStack(DavCraft.itemIronPunch, 1, OreDictionary.WILDCARD_VALUE),
			'f', fuel, 'm', material
		});
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityStoneTorch();
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(DavCraft.modid + ":StoneTorch_icon");
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return world.isSideSolid(x - 1, y, z, EAST,  true) ||
               world.isSideSolid(x + 1, y, z, WEST,  true) ||
               world.isSideSolid(x, y, z - 1, SOUTH, true) ||
               world.isSideSolid(x, y, z + 1, NORTH, true) ||
               canPlaceOnTopOfBlock(world, x, y - 1, z);
    }
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess blockAccess, int x, int y, int z) {
		int metaData = blockAccess.getBlockMetadata(x, y, z);
		//this.setBlockBounds(6f/16f, 0f, 6f/16f, 10f/16f, 12f/16f, 10f/16f);
		float minX = 6f/16f;
		float minY = 0f;
		float minZ = 6f/16f;
		float maxX = 10f/16f;
		float maxY = 12f/16f;
		float maxZ = 10f/16f;
		if ((metaData & 1) != 0)
			minX = 0;
		if ((metaData & 2) != 0)
			maxX = 1;
		if ((metaData & 4) != 0)
			minZ = 0;
		if ((metaData & 8) != 0)
			maxZ = 1;
		
		this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
	}
	
	private boolean canPlaceOnTopOfBlock(World world, int x, int y, int z)
    {
        if (World.doesBlockHaveSolidTopSurface(world, x, y, z))
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(x, y, z);
            return block.canPlaceTorchOnTop(world, x, y, z);
        }
    }
	
	public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metaData) {
		
		return this.generateMetaData(world, x, y, z);
	}
	
	public void onBlockAdded(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, this.generateMetaData(world, x, y, z), 2);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour)
    {
		int metaData = this.generateMetaData(world, x, y, z);
		if (!this.canPlaceBlockAt(world, x, y, z)) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(this));
			world.setBlockToAir(x, y, z);
		}
		else 
		{
			world.setBlockMetadataWithNotify(x, y, z, metaData, 2);
		}
    }
	
	private int generateMetaData(World world, int x, int y, int z) {

		int metaData = 0;
		if (world.isSideSolid(x - 1, y, z, EAST, true))
			metaData |= 1;
		if (world.isSideSolid(x + 1, y, z, WEST, true))
			metaData |= 2;
		if (world.isSideSolid(x, y, z - 1, SOUTH, true))
			metaData |= 4;
		if (world.isSideSolid(x, y, z + 1, NORTH, true))
			metaData |= 8;
		return metaData;
	}
	
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        double d0 = (double)((float)x + 8f/16f);
        double d1 = (double)((float)y + 13f/16f);
        double d2 = (double)((float)z + 8f/16f);
        
        world.spawnParticle("smoke", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        world.spawnParticle("flame", d0, d1, d2, 0.0D, 0.0D, 0.0D);
    }
}
