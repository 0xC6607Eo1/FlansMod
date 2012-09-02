package flan.server;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.ItemStack;

public class AAGunType extends InfoType
{
	public List<BulletType> ammo = new ArrayList<BulletType>();
	public int reloadTime;
	public int recoil = 5;
	public int accuracy;
	public int damage;
	public int shootDelay;
	public int numBarrels;
	public boolean fireAlternately;
	public int health;
	public int gunnerX;
	public int gunnerY;
	public int gunnerZ;
	public String shootSound;
	public String reloadSound;
	public Object model;
	public String texture;
	public float topViewLimit = 75F;
	public float bottomViewLimit = 0F;
	public static List<AAGunType> types = new ArrayList<AAGunType>();
	
	public AAGunType(BufferedReader file, String pack)
	{
		super(pack);
		//TODO
	}
	
	protected void read()
	{
		//TODO
	}
		
	public boolean isAmmo(BulletType type)
	{
		return ammo.contains(type);
	}
	
	public boolean isAmmo(ItemStack stack)
	{
		//TODO
		return false;
	}
		
	public static AAGunType getAAGun(String s)
	{
		for(AAGunType gun : types)
		{
			if(gun.shortName.equals(s))
				return gun;
		}
		return null;
	}
}
