package flan.server;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Slot;
import net.minecraft.src.World;

public class ContainerPlaneInventory extends Container
{
    public ContainerPlaneInventory(InventoryPlayer inventoryplayer, World worldy, EntityDriveable entPlane, int i)
    {
		inventory = inventoryplayer;
        world = worldy;
		plane = entPlane;
		screen = i;
		//Find the number of items in the inventory
		numItems = 0;
		switch(i)
		{
			case 0 :
			{
				for(int j = 0; j < plane.superData.guns.length; j++)
				{
					if(plane.superData.guns[j] != null)
						numItems++;
				}	
				maxScroll = (numItems > 3 ? numItems - 3 : 0);
				break;
			}
			case 1 : 
			{
				numItems = plane.superType.numBombSlots;
				maxScroll = ((int)((numItems + 7) / 8) > 3 ? (int)((numItems + 7) / 8) - 3 : 0);
				break;
			}
			case 2 : 
			{
				numItems = plane.superType.numCargoSlots;
				maxScroll = ((int)((numItems + 7) / 8) > 3 ? (int)((numItems + 7) / 8) - 3 : 0);
				break;
			}	
		}
		
		//Add screen specific slots
		switch(screen)
		{
			case 0 : //Guns
			{
				int slotsDone = 0;
				for(int j = 0; j < plane.superData.guns.length; j++)
				{
					if(plane.superData.guns[j] != null)
					{
						int yPos = -1000;
						if(slotsDone < 3 + scroll && slotsDone >= scroll)
							yPos = 25 + 19 * slotsDone;
						addSlotToContainer(new Slot(plane.superData, j, 29, yPos));
						slotsDone++;
					}
				}	
				break;
			}
			case 1 : //Bombs
			case 2 : //Cargo
			{
				int startSlot = plane.superData.getBombInventoryStart();
				if(screen == 2)
					startSlot = plane.superData.getCargoInventoryStart();
				int m = (int)((numItems + 7) / 8);
				for(int row = 0; row < m; row++)
				{
					int yPos = -1000;
					if(row < 3 + scroll && row >= scroll)
						yPos = 25 + 19 * (row - scroll);
					for(int col = 0; col < ((row + scroll + 1) * 8 < numItems ? 8 : numItems % 8); col++)
					{
						addSlotToContainer(new Slot(plane.superData, startSlot + row * 8 + col, 10 + 18 * col, yPos));
					}
				}
				break;
			}
		}
		
		//Main inventory slots
        for(int row = 0; row < 3; row++)
        {
            for(int col = 0; col < 9; col++)
            {
            	addSlotToContainer(new Slot(inventoryplayer, col + row * 9 + 9, 8 + col * 18, 98 + row * 18));
            }

        }
		//Quickbar slots
        for(int col = 0; col < 9; col++)
        {
        	addSlotToContainer(new Slot(inventoryplayer, col, 8 + col * 18, 156));
        }
    }
	
	public ItemStack transferStackInSlot(int i)
    {
        return null;
    }
	
	public void updateScroll(int scrololol)
	{
		scroll = scrololol;
		switch(screen)
		{
			case 0 :
			{
				int slotsDone = 0;
				for(int i = 0; i < plane.superData.guns.length; i++)
				{
					if(plane.superData.guns[i] != null)
					{
						int yPos = -1000;
						if(slotsDone < 3 + scroll && slotsDone >= scroll)
							yPos = 25 + 19 * (slotsDone - scroll);
						((Slot)inventorySlots.get(slotsDone)).yDisplayPosition = yPos;
						slotsDone++;
					}
				}	
				break;
			}
			case 1 :
			case 2 :
			{
				int m = (int)((numItems + 7) / 8);
				for(int row = 0; row < m; row++)
				{
					int yPos = -1000;
					if(row < 3 + scroll && row >= scroll)
						yPos = 25 + 19 * (row - scroll);
					for(int col = 0; col < ((row + 1) * 8 < numItems ? 8 : numItems % 8); col++)
					{
						((Slot)inventorySlots.get(row * 8 + col)).yDisplayPosition = yPos;
					}
				}
				break;
			}
		}
	}

    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return entityplayer.ridingEntity != null && entityplayer.ridingEntity instanceof EntityDriveable;
    }

	public InventoryPlayer inventory;
    public World world;
	public EntityDriveable plane;
	public int numItems;
	public int screen;
	public int maxScroll;
	public int scroll;
}
