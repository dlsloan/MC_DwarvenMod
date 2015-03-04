package net.davcraft.mod.items.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class DCTools {

	public static ToolMaterial toolIronStoneMaterial = getMaterialWithIronHandle("IronStoneMaterial", ToolMaterial.STONE);
	public static ToolMaterial toolIronIronMaterial = getMaterialWithIronHandle("IronIronMaterial", ToolMaterial.IRON);
	public static ToolMaterial toolIronGoldMaterial = getMaterialWithIronHandle("IronGoldMaterial", ToolMaterial.GOLD);
	public static ToolMaterial toolIronDiamondMaterial = getMaterialWithIronHandle("IronDiamondMaterial", ToolMaterial.EMERALD);
			
	private static ToolMaterial getMaterialWithIronHandle(String name, ToolMaterial base) {
		return EnumHelper.addToolMaterial(name, 
				base.getHarvestLevel(),
				base.getMaxUses() * 2, 
				base.getEfficiencyOnProperMaterial() * 1.2f, 
				base.getDamageVsEntity() * 1.1f, 
				base.getEnchantability());
	}

}
