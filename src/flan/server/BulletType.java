package flan.server;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class BulletType 
{
	public Object model;
	public String texture = "bullet";
	public float fallSpeed = 1.0F;
	public int damage = 0;
	public int explosion = 0;
	public boolean explodeOnImpact = false;
	public int fuse = 0;
	public int flak = 0;
	public int fire = 0;
	public String dropItemOnReload = null;
	public String dropItemOnShoot = null;
	public String dropItemOnHit = null;
	public boolean breaksGlass = false;
	public boolean penetrates = false;
	public boolean smokeTrail = false;
	public boolean isBomb = false;
	public boolean isShell = false;
	public float hitBoxSize = 0.5F;
	public String hitSound;
	public int roundsPerItem = 1;
	public int maxStackSize = 1;
	private static int lastIconIndex = 0;
	public static List<BulletType> bullets = new ArrayList<BulletType>();
	
	public BulletType()
	{
		
	}
	
	protected void read(String[] arg0, BufferedReader file) {}
	
	public static BulletType getBullet(String s)
	{
		//TODO
		return null;
	}
	
	public static BulletType getBullet(int id)
	{
		//TODO
		return null;
	}
}
