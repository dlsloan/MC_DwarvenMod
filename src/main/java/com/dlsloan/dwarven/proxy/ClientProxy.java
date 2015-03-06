package com.dlsloan.dwarven.proxy;

import com.dlsloan.dwarven.init.ModItems;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
	}
}
