package space.plague.chattimestamps;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import space.plague.chattimestamps.config.ChatTimestampsConfig;

@Mod("plagueschattimestamps")
public class Main {

    public static final String MOD_ID = "plagueschattimestamps";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public Main() {
        ChatTimestampsConfig.register(FMLJavaModLoadingContext.get().getModEventBus());
        LOGGER.info("Plague's Chat Timestamps loaded.");
    }
}