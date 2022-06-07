package mrnerdy42.keywizard.forge.event;

import mrnerdy42.keywizard.forge.KeyWizard;
import mrnerdy42.keywizard.gui.KeyWizardScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

//import mrnerdy42.keywizard.gui.KeyWizardScreen;

public class ClientEventHandler {
	
    @SubscribeEvent
    public void keyPressed(KeyInputEvent e) {
        if (KeyWizard.keyOpenKeyWizard.isPressed()) {
            MinecraftClient client = MinecraftClient.getInstance();
            client.openScreen(new KeyWizardScreen(client.currentScreen));
        }
    }

}
