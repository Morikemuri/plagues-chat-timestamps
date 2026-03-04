package space.plague.chattimestamps.mixin;

import net.minecraft.client.gui.NewChatGui;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import space.plague.chattimestamps.config.ChatTimestampsConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

@OnlyIn(Dist.CLIENT)
@Mixin(NewChatGui.class)
public class MixinChatHud {

    @ModifyVariable(
            method = "addMessage(Lnet/minecraft/util/text/ITextComponent;IIZ)V",
            at = @At("HEAD"),
            argsOnly = true,
            index = 1
    )
    private ITextComponent plagueschattimestamps$prependTimestamp(ITextComponent original) {
        if (ChatTimestampsConfig.CLIENT.disableMod.get()) {
            return original;
        }
        String format = ChatTimestampsConfig.CLIENT.timestampFormat.get();
        String timestamp = buildTimestamp(format);
        return new StringTextComponent(timestamp).append(original);
    }

    private String buildTimestamp(String format) {
        // Separate & color codes from date pattern
        StringBuilder colorCodes = new StringBuilder();
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == '&' && i + 1 < format.length()) {
                char code = format.charAt(i + 1);
                if ("0123456789abcdefklmnor".indexOf(code) >= 0) {
                    colorCodes.append('\u00a7').append(code);
                    i++;
                    continue;
                }
            }
            pattern.append(format.charAt(i));
        }
        try {
            String formatted = new SimpleDateFormat(pattern.toString()).format(new Date());
            return colorCodes + formatted;
        } catch (IllegalArgumentException e) {
            return format;
        }
    }
}