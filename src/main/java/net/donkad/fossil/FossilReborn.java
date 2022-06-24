package net.donkad.fossil;

import net.donkad.fossil.entity.EntityInit;
import net.donkad.fossil.items.ItemsInit;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FossilReborn implements ModInitializer {
	public static final String MODID = "fossil";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	

	@Override
	public void onInitialize() {

		EntityInit.init();
		ItemsInit.init();

		LOGGER.info("Hello Fabric world!");
	}
}
