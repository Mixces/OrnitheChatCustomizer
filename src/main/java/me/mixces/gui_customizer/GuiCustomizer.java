package me.mixces.gui_customizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

public class GuiCustomizer implements ModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("Example Mod");

	@Override
	public void init() {
		LOGGER.info("initializing example mod!");
	}
}
