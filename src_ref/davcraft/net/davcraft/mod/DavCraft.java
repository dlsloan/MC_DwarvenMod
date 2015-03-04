package net.davcraft.mod;

import net.davcraft.mod.blocks.CopperBlock;
import net.davcraft.mod.blocks.CopperOre;
import net.davcraft.mod.blocks.StoneTorch;
import net.davcraft.mod.handler.CraftingHandler;
import net.davcraft.mod.handler.FuelHandler;
import net.davcraft.mod.items.DCItem;
import net.davcraft.mod.items.tools.Axe;
import net.davcraft.mod.items.tools.Hoe;
import net.davcraft.mod.items.tools.Pickaxe;
import net.davcraft.mod.items.tools.DCTools;
import net.davcraft.mod.items.tools.IronHammer;
import net.davcraft.mod.items.tools.IronPunch;
import net.davcraft.mod.items.tools.Shovel;
import net.davcraft.mod.items.tools.Sword;
import net.davcraft.mod.proxy.CommonProxy;
import net.davcraft.mod.worldgen.DavCraftWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@Mod(modid = DavCraft.modid, version = DavCraft.version)
public class DavCraft {
	public static final String modid = "DavCraft";
	public static final String version = "Alpha v0.1";

	DavCraftWorldGen eventWorldGen = new DavCraftWorldGen();
	
	public static CreativeTabs davcraftTab;
	
	@Instance(modid)
	public static DavCraft instance;
	
	//Generic Items
	public static Item itemCopperIngot;
	public static Item itemRocks;
	public static Item itemFuelOrb;
	
	//Craftable Items
	public static Item itemIronRod;
	
	//Tools
	public static Item itemIronHammer;
	public static Item itemIronPunch;

	public static Item itemIronHandledStonePickaxe;
	public static Item itemIronHandledStoneAxe;
	public static Item itemIronHandledStoneHoe;
	public static Item itemIronHandledStoneShovel;
	public static Item itemIronHandledStoneSword;

	public static Item itemIronHandledIronPickaxe;
	public static Item itemIronHandledIronAxe;
	public static Item itemIronHandledIronHoe;
	public static Item itemIronHandledIronShovel;
	public static Item itemIronHandledIronSword;

	public static Item itemIronHandledGoldPickaxe;
	public static Item itemIronHandledGoldAxe;
	public static Item itemIronHandledGoldHoe;
	public static Item itemIronHandledGoldShovel;
	public static Item itemIronHandledGoldSword;

	public static Item itemIronHandledDiamondPickaxe;
	public static Item itemIronHandledDiamondAxe;
	public static Item itemIronHandledDiamondHoe;
	public static Item itemIronHandledDiamondShovel;
	public static Item itemIronHandledDiamondSword;
	
	//Ore
	public static Block blockCopperOre;
	
	//Blocks
	public static Block blockCopperBlock; 
	public static Block blockStoneTorch;
	public static Block blobkCobbleStoneCraftingTable;
	
	@SidedProxy(clientSide = "net.davcraft.mod.proxy.ClientProxy", serverSide = "net.davcraft.mod.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {
		
		davcraftTab = new CreativeTabs("DavCraft") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(DavCraft.blockCopperOre);
			}
		};
		
		itemCopperIngot = createItem("CopperIngot");
		itemRocks = createItem("Rocks");
		
		itemFuelOrb = createItem("FuelOrb");
		
		itemIronRod = createItem("IronRod");	
		
		//Tools
		itemIronHammer = createItem(new IronHammer(), "IronHammer");
		itemIronPunch = createItem(new IronPunch(), "IronPunch");
		
		itemIronHandledStonePickaxe = createItem(new Pickaxe(DCTools.toolIronStoneMaterial), "IronStonePickaxe");
		itemIronHandledStoneAxe = createItem(new Axe(DCTools.toolIronStoneMaterial), "IronStoneAxe");
		itemIronHandledStoneHoe = createItem(new Hoe(DCTools.toolIronStoneMaterial), "IronStoneHoe");
		itemIronHandledStoneShovel = createItem(new Shovel(DCTools.toolIronStoneMaterial), "IronStoneShovel");
		itemIronHandledStoneSword = createItem(new Sword(DCTools.toolIronStoneMaterial), "IronStoneSword");
		
		itemIronHandledIronPickaxe = createItem(new Pickaxe(DCTools.toolIronIronMaterial), "IronIronPickaxe");
		itemIronHandledIronAxe = createItem(new Axe(DCTools.toolIronIronMaterial), "IronIronAxe");
		itemIronHandledIronHoe = createItem(new Hoe(DCTools.toolIronIronMaterial), "IronIronHoe");
		itemIronHandledIronShovel = createItem(new Shovel(DCTools.toolIronIronMaterial), "IronIronShovel");
		itemIronHandledIronSword = createItem(new Sword(DCTools.toolIronIronMaterial), "IronIronSword");
		
		itemIronHandledGoldPickaxe = createItem(new Pickaxe(DCTools.toolIronGoldMaterial), "IronGoldPickaxe");
		itemIronHandledGoldAxe = createItem(new Axe(DCTools.toolIronGoldMaterial), "IronGoldAxe");
		itemIronHandledGoldHoe = createItem(new Hoe(DCTools.toolIronGoldMaterial), "IronGoldHoe");
		itemIronHandledGoldShovel = createItem(new Shovel(DCTools.toolIronGoldMaterial), "IronGoldShovel");
		itemIronHandledGoldSword = createItem(new Sword(DCTools.toolIronGoldMaterial), "IronGoldSword");
		
		itemIronHandledDiamondPickaxe = createItem(new Pickaxe(DCTools.toolIronDiamondMaterial), "IronDiamondPickaxe");
		itemIronHandledDiamondAxe = createItem(new Axe(DCTools.toolIronDiamondMaterial), "IronDiamondAxe");
		itemIronHandledDiamondHoe = createItem(new Hoe(DCTools.toolIronDiamondMaterial), "IronDiamondHoe");
		itemIronHandledDiamondShovel = createItem(new Shovel(DCTools.toolIronDiamondMaterial), "IronDiamondShovel");
		itemIronHandledDiamondSword = createItem(new Sword(DCTools.toolIronDiamondMaterial), "IronDiamondSword");
		
		blockCopperOre = createBlock(new CopperOre(Material.rock), "CopperOre");		
		blockCopperBlock = createBlock(new CopperBlock(Material.iron), "CopperBlock");
		blockStoneTorch = createBlock(new StoneTorch(), "StoneTorch");
		blobkCobbleStoneCraftingTable = createBlock(new CobbleStoneCraftingTable(Material.rock), "CobbleStoneCraftingTable");
		
		//Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
		//Renderers
		proxy.registerRenderThings();
	}
	
	private Item createItem(String name) {
		Item item = new DCItem().setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
		return item;
	}
	
	private Item createItem(Item item, String name) {
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
		return item;
	}
	
	private Block createBlock(Block block, String name) {
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
		return block;
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent preEvent) {
		
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		
		//Recipies
		//GameRegistry.addShapelessRecipe(new ItemStack(blockCopperOre), new Object[] {
		//	itemCopperIngot, Blocks.cobblestone
		//});
		
		GameRegistry.addRecipe(new ItemStack(blockCopperBlock, 1), new Object[] {
			"ccc", 
			"ccc", 
			"ccc", 
			'c', itemCopperIngot
		});
		
		GameRegistry.addRecipe(new ItemStack(itemIronRod, 4), new Object[] {
			"h ", 
			" i",  
			'h', new ItemStack(itemIronHammer, 1, OreDictionary.WILDCARD_VALUE), 'i', Items.iron_ingot
		});
		
		GameRegistry.addShapelessRecipe(new ItemStack(itemRocks, 4), new Object[] {Blocks.cobblestone, 
			new ItemStack(itemIronPunch, 1, OreDictionary.WILDCARD_VALUE)});
		
		((IronHammer)itemIronHammer).generateRecipe(Items.stick, Items.iron_ingot);
		((IronPunch)itemIronPunch).generateRecipe(itemIronRod);
		((StoneTorch)blockStoneTorch).generateRecipe(Blocks.cobblestone, Items.coal);
		((CobbleStoneCraftingTable)blobkCobbleStoneCraftingTable).generateRecipe(Blocks.cobblestone);

		((Axe)itemIronHandledStoneAxe).generateRecipe(itemIronRod, Blocks.cobblestone);
		((Pickaxe)itemIronHandledStonePickaxe).generateRecipe(itemIronRod, Blocks.cobblestone);
		((Shovel)itemIronHandledStoneShovel).generateRecipe(itemIronRod, Blocks.cobblestone);
		((Hoe)itemIronHandledStoneHoe).generateRecipe(itemIronRod, Blocks.cobblestone);
		((Sword)itemIronHandledStoneSword).generateRecipe(itemIronRod, Blocks.cobblestone);

		((Axe)itemIronHandledIronAxe).generateRecipe(itemIronRod, Items.iron_ingot);
		((Pickaxe)itemIronHandledIronPickaxe).generateRecipe(itemIronRod, Items.iron_ingot);
		((Shovel)itemIronHandledIronShovel).generateRecipe(itemIronRod, Items.iron_ingot);
		((Hoe)itemIronHandledIronHoe).generateRecipe(itemIronRod, Items.iron_ingot);
		((Sword)itemIronHandledIronSword).generateRecipe(itemIronRod, Items.iron_ingot);

		((Axe)itemIronHandledGoldAxe).generateRecipe(itemIronRod, Items.gold_ingot);
		((Pickaxe)itemIronHandledGoldPickaxe).generateRecipe(itemIronRod, Items.gold_ingot);
		((Shovel)itemIronHandledGoldShovel).generateRecipe(itemIronRod, Items.gold_ingot);
		((Hoe)itemIronHandledGoldHoe).generateRecipe(itemIronRod, Items.gold_ingot);
		((Sword)itemIronHandledGoldSword).generateRecipe(itemIronRod, Items.gold_ingot);

		((Axe)itemIronHandledDiamondAxe).generateRecipe(itemIronRod, Items.diamond);
		((Pickaxe)itemIronHandledDiamondPickaxe).generateRecipe(itemIronRod, Items.diamond);
		((Shovel)itemIronHandledDiamondShovel).generateRecipe(itemIronRod, Items.diamond);
		((Hoe)itemIronHandledDiamondHoe).generateRecipe(itemIronRod, Items.diamond);
		((Sword)itemIronHandledDiamondSword).generateRecipe(itemIronRod, Items.diamond);
		
		//Smelting
		GameRegistry.addSmelting(blockCopperOre, new ItemStack(itemCopperIngot, 1), 1f);
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent preEvent) {
		
	}
}