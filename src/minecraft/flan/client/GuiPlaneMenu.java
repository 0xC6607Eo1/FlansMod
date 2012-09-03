package flan.client;

import net.minecraft.client.Minecraft;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.World;

import org.lwjgl.opengl.GL11;

import flan.server.ContainerPlaneMenu;
import flan.server.EntityDriveable;
import flan.server.EntityPlane;

public class GuiPlaneMenu extends GuiContainer
{
    public GuiPlaneMenu(InventoryPlayer inventoryplayer, World world1, EntityDriveable entPlane)
    {
        super(new ContainerPlaneMenu(inventoryplayer, world1));
		entity = entPlane;
		ySize = 180;
		world = world1;
		inventory = inventoryplayer;
    }
	
	public void initGui()
	{
		super.initGui();
		controlList.add(new GuiButton(0, width / 2 - 60, height / 2 - 71, 58, 20, "Guns"));
		controlList.add(new GuiButton(1, width / 2 + 2, height / 2 - 71, 58, 20, (entity instanceof EntityPlane ? "Bombs" : "Shells")));
		controlList.add(new GuiButton(2, width / 2 - 60, height / 2 - 49, 58, 20, "Fuel"));
		controlList.add(new GuiButton(3, width / 2 + 2, height / 2 - 49, 58, 20, "Cargo"));
	}
	
	protected void actionPerformed(GuiButton button)
    {
        if (button.id == 0) //Guns
        {
            mc.displayGuiScreen(new GuiPlaneInventory(inventory, world, entity, 0));
        }
        if (button.id == 1) //Bombs
        {
            mc.displayGuiScreen(new GuiPlaneInventory(inventory, world, entity, 1));
        }
        if (button.id == 2) //Fuel
        {
            mc.displayGuiScreen(new GuiPlaneFuel(inventory, world, entity));
        } 
		if (button.id == 3) //Cargo
        {
            mc.displayGuiScreen(new GuiPlaneInventory(inventory, world, entity, 2));
        }
    }

    protected void drawGuiContainerForegroundLayer()
    {
        fontRenderer.drawString(entity.superType.name, 6, 6, 0x404040);
        fontRenderer.drawString("Inventory", 8, (ySize - 96) + 2, 0x404040);
    }

    protected void drawGuiContainerBackgroundLayer(float f, int i1, int j1)
    {
        int i = mc.renderEngine.getTexture("/gui/planeMenu.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(i);
        int j = (width - xSize) / 2;
        int k = (height - ySize) / 2;
        drawTexturedModalRect(j, k, 0, 0, xSize, ySize);
    }

	public World world;
	public InventoryPlayer inventory;
	public EntityDriveable entity;
}
