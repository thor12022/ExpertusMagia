package thor12022.expertusmagia.client.gui;

import thor12022.expertusmagia.ExpertusMagia;
import thor12022.expertusmagia.client.gui.BaseBook.ItemGuiBaseBook;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
			ExpertusMagia.logger.info("Open Gui");
			return new ItemGuiBaseBook();
		}
		return null;
	}
}
