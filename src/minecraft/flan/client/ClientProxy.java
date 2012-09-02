package flan.client;

import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.registry.TickRegistry;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.ModelBase;
import net.minecraft.src.Vec3;
import net.minecraft.src.World;
import flan.server.AAGunType;
import flan.server.BulletType;
import flan.server.CommonProxy;
import flan.server.EntityAAGun;
import flan.server.EntityBullet;
import flan.server.FlansMod;
import flan.server.ItemBullet;

public class ClientProxy extends CommonProxy
{
	public void load() 
	{
		new FlansModClient().load();
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
	}
	
	public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		return null;
	}
	
	public ModelBase loadBulletModel(String[] split, String shortName)
	{
		String s = "flan.client.Model";
		try 
		{	
			ModelBase model = (ModelBase)Class.forName(s + split[1]).getConstructor().newInstance();
			return model;
		}
		catch(Exception e)
		{
			FlansMod.log("Failed to load bullet model : " + shortName);
			e.printStackTrace();
			return null;
		}
	}
	
	public ModelMG loadMGModel(String[] split, String shortName)
	{
		String s = "flan.client.Model";
		try 
		{	
			ModelMG model = (ModelMG)Class.forName(s + split[1]).getConstructor().newInstance();
			return model;
		}
		catch(Exception e)
		{
			FlansMod.log("Failed to load deployable MG model : " + shortName);
			e.printStackTrace();
			return null;
		}
	}
	
	public ModelAAGun loadAAGunModel(String[] split, String shortName)
	{
		String s = "flan.client.Model";
		try 
		{	
			ModelAAGun model = (ModelAAGun)Class.forName(s + split[1]).getConstructor().newInstance();
			return model;
		}
		catch(Exception e)
		{
			FlansMod.log("Failed to load AA gun model : " + shortName);
			e.printStackTrace();
			return null;
		}
	}
	
	public void spawnAAGun(World world, double posX, double posY, double posZ, AAGunType type, float gunYaw, float gunPitch, Random rand, BulletType bullet, EntityAAGun entity, Entity player)
	{
		ModelAAGun model = (ModelAAGun)type.model;
		world.spawnEntityInWorld(new EntityBullet(world, entity.rotate(model.barrelX / 16D + 3D, model.barrelY / 16D, model.barrelZ / 16D + 3D).addVector(posX, posY, posZ), gunYaw + 90F, gunPitch, (EntityLiving)player, type.accuracy, type.damage, bullet));
		world.playSoundAtEntity(entity, type.shootSound, 1.0F, 1.0F / (rand.nextFloat() * 0.4F + 0.8F));
	}
}
