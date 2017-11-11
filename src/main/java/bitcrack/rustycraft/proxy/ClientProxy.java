package bitcrack.rustycraft.proxy;

import bitcrack.rustycraft.init.ModBlocks;
import bitcrack.rustycraft.init.ModItems;

public class ClientProxy implements CommonProxy {

	@Override
	public void init() {
		ModItems.registerRenders();
		ModBlocks.registerRenders();
	}

}
