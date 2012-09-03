package flan.server;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockManyNames extends ItemBlock {
	
	public ItemBlockManyNames(int i)
	{
		super(i);
	}
	
	public String getItemNameIS(ItemStack stack)
	{
		int damage = stack.getItemDamage();
		return getItemName() + damage;
	}
}
