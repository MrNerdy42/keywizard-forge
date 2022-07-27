package mrnerdy42.keywizard.forge;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

import mrnerdy42.keywizard.forge.event.ClientEventHandler;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(KeyWizard.MODID)
public class KeyWizard {

    
	
	public static final String MODID = "keywizard";
	public static final Logger LOGGER = LogManager.getLogger(MODID);
    public static final Identifier SCREEN_TOGGLE_WIDGETS = new Identifier(MODID, "textures/gui/screen_toggle_widgets.png");

    public static KeyBinding keyOpenKeyWizard = new KeyBinding("key." + MODID + ".openKeyWizard", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_F7, "key.categories." + MODID + ".bindings");
	
	public KeyWizard() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        ClientRegistry.registerKeyBinding(keyOpenKeyWizard);
        
        //ModLoadingContext.get().registerConfig(Type.CLIENT, KeyWizardConfig.SPEC, "keywizard-client.toml");
	}
	
    public void clientSetup(final FMLClientSetupEvent e) {
    	LOGGER.log(Level.DEBUG, MODID);
    	MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
    }
}


