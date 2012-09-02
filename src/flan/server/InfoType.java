package flan.server;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;

public class InfoType 
{
	/** infoTypes */
	public static List<InfoType> infoTypes = new ArrayList<InfoType>();
	
	public String contentPack;
	public Item item;
	public int colour = 0xffffff;
	public int itemID;
	public String iconPath;
	public int iconIndex;
	public Object[] recipe;
	public String[] recipeLine;
	public int recipeOutput = 1;
	public boolean shapeless;
	public String smeltableFrom = null;	
	public String name;
	public String shortName;
	
	public InfoType()
    {
		infoTypes.add(this);
    }
	
	public InfoType(String pack)
	{
		this();
		contentPack = pack;
	}
	
	/** Pack reader */
	protected void read()
	{
		//TODO
	}
	
	public void addRecpie()
	{
		this.addRecpie(getItem());
	}
	
	public void addRecpie(Item par1Item)
	{
		//TODO
	}
	
	public Item getItem()
	{
		return item;
	}
	
	public static ItemStack getRecipeElement(String arg0, int damage)
	{
		//TODO
		return null;
	}
}
