package flan.server;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;

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
	public static List<AAGunType> infoTypes = new ArrayList<AAGunType>();
	
	public AAGunType(BufferedReader file, String pack)
	{
		super(pack);
		do
		{
			String line = null;
			try
			{
				line = file.readLine();
			}
			catch(Exception e)
			{
				break;
			}
			if(line == null)
			{
				break;
			}
			if(line.startsWith("//"))
				continue;
			String[] split = line.split(" ");
			if(split.length < 2)
				continue;
			read(split, file);
		}
		while(true);
		infoTypes.add(this);
		//TODO 'iconIndex' missing ?
	}
	
	protected void read(String[] arg0, BufferedReader file)
	{
		super.read(arg0, file);
		try
		{
			if(arg0[0].equals("Model"))
			{
				//TODO
			}
			if(arg0[0].equals("Texture"))
			{
				texture = arg0[1];
			}
			if(arg0[0].equals("Damage"))
			{
				damage = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("ReloadTime"))
			{
				reloadTime = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("Recoil"))
			{
				recoil = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("Accuracy"))
			{
				accuracy = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("ShootDelay"))
			{
				shootDelay = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("ShootSound"))
			{
				shootSound = "aaguns." + arg0[1];
				FMLClientHandler.instance().getClient().installResource("newSound/aaguns/" + arg0[1] + ".ogg", new File(FMLClientHandler.instance().getClient().mcDataDir, "/Flan/" + contentPack + "/sounds/" + arg0[1] + ".ogg"));
			}
			if(arg0[0].equals("ReloadSound"))
			{
				reloadSound = "aaguns." + arg0[1];
				FMLClientHandler.instance().getClient().installResource("newSound/aaguns/" + arg0[1] + ".ogg", new File(FMLClientHandler.instance().getClient().mcDataDir, "/Flan/" + contentPack + "/sounds/" + arg0[1] + ".ogg"));
			}
			if(arg0[0].equals("FireAlternately"))
			{
				fireAlternately = arg0[1].equals("True");
			}
			if(arg0[0].equals("NumBarrels"))
			{
				numBarrels = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("Health"))
			{
				health = Integer.parseInt(arg0[1]);
			}
			if(arg0[0].equals("TopViewLimit"))
			{
				topViewLimit = Float.parseFloat(arg0[1]);
			}
			if(arg0[0].equals("BottomViewLimit"))
			{
				bottomViewLimit = Float.parseFloat(arg0[1]);
			}
			if(arg0[0].equals("Ammo"))
			{
				BulletType type = null;
				if(type != null)
				{
					ammo.add(type);
				}
				//TODO
			}			
			if(arg0[0].equals("GunnerPos"))
			{
				gunnerX = Integer.parseInt(arg0[1]);
				gunnerY = Integer.parseInt(arg0[2]);
				gunnerZ = Integer.parseInt(arg0[3]);				
			}
		}
		catch(Exception e)
		{
			FlansMod.log(""+e);
		}
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
		for(AAGunType gun : infoTypes)
		{
			if(gun.shortName.equals(s))
				return gun;
		}
		return null;
	}
}
