package net.davcraft.mod.handler;

import net.davcraft.mod.DavCraft;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		if (fuel.getItem() == DavCraft.itemFuelOrb) return 16000;
		return 0;
	}

}
