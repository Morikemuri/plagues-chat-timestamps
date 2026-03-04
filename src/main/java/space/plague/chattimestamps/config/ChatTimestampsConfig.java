package space.plague.chattimestamps.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.config.ModConfig;

public class ChatTimestampsConfig {

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        CLIENT = new ClientConfig(builder);
        CLIENT_SPEC = builder.build();
    }

    public static void register(IEventBus bus) {
        bus.register(ChatTimestampsConfig.class);
        net.minecraftforge.fml.ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, CLIENT_SPEC, "plagueschattimestamps.toml");
    }

    public static class ClientConfig {

        public final ForgeConfigSpec.ConfigValue<String> timestampFormat;
        public final ForgeConfigSpec.BooleanValue disableMod;

        public ClientConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Plague's Chat Timestamps settings").push("general");

            timestampFormat = builder
                    .comment("Timestamp format. Use & for Minecraft color codes, e.g. &b[dd.MM.yyyy HH:mm:ss] ")
                    .define("timestamp_format", "&b[dd.MM.yyyy HH:mm:ss] ");

            disableMod = builder
                    .comment("Set to true to disable the mod entirely.")
                    .define("disable_mod", false);

            builder.pop();
        }
    }
}