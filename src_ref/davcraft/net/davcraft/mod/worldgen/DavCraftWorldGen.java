package net.davcraft.mod.worldgen;

import java.util.Random;

import net.davcraft.mod.DavCraft;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class DavCraftWorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		switch(world.provider.dimensionId)
		{
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}

	private void generateSurface(World world, Random rand, int x, int z) {
		this.addOreSpawn(DavCraft.blockCopperOre, world, rand, x, z, 16, 16, 12, 25, 12, 100);
	}

	private void generateNether(World world, Random rand, int x, int z) {
		// TODO Auto-generated method stub
		
	}

	private void generateEnd(World world, Random rand, int x, int z) {
		// TODO Auto-generated method stub
		
	}

	private void addOreSpawn(Block block, World world, Random rand,
			int x, int z, int sizeX, int sizeZ, int veinSize, int chanceToSpawn, int minY, int maxY) {
		for (int i = 0; i < chanceToSpawn; i++) {
			int posX = x + rand.nextInt(sizeX);
			int posY = minY + rand.nextInt(maxY - minY);
			int posZ = z + rand.nextInt(sizeZ);
			(new WorldGenMinable(block, veinSize)).generate(world, rand, posX, posY, posZ);
		}
	}

}
