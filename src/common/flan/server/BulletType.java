package flan.server;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class BulletType extends InfoType
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

	public BulletType(BufferedReader file)
	{
		do
		{
			String line = null;
			try
			{
				line = file.readLine();
			} catch (Exception e)
			{
				break;
			}
			if (line == null)
			{
				break;
			}
			if (line.startsWith("//"))
				continue;
			String[] split = line.split(" ");
			if (split.length < 2)
				continue;
			read(split, file);
		} while (true);
		bullets.add(this);
		iconIndex = lastIconIndex++;
	}

	protected void read(String[] arg0, BufferedReader file)
	{
		super.read(arg0, file);
		try
		{
			if (arg0[0].equals("Model"))
			{
				model = FlansMod.proxy.loadBulletModel(arg0, shortName);
			}
			if (arg0[0].equals("Texture"))
				texture = arg0[1];
			if (arg0[0].equals("FallSpeed"))
				fallSpeed = Float.parseFloat(arg0[1]);
			if (arg0[0].equals("Damage"))
				damage = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("Explosion"))
				explosion = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("FlakParticles"))
				flak = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("Fire"))
				fire = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("ExpodeOnImpact"))
				explodeOnImpact = arg0[1].equals("True");
			if (arg0[0].equals("Fuse"))
				fuse = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("BreaksGlass"))
				breaksGlass = arg0[1].equals("True");
			if (arg0[0].equals("HitBoxSize"))
				hitBoxSize = Float.parseFloat(arg0[1]);
			if (arg0[0].equals("HitSound"))
				hitSound = arg0[1];
			if (arg0[0].equals("Penetrates"))
				penetrates = arg0[1].equals("True");
			if (arg0[0].equals("SmokeTrail"))
				smokeTrail = arg0[1].equals("True");
			if (arg0[0].equals("RoundsPerItem"))
				roundsPerItem = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("MaxStackSize"))
				maxStackSize = Integer.parseInt(arg0[1]);
			if (arg0[0].equals("Bomb"))
				isBomb = arg0[1].equals("True");
			if (arg0[0].equals("Shell"))
				isShell = arg0[1].equals("True");
			if (arg0[0].equals("DropItemOnShoot"))
				dropItemOnShoot = arg0[1];
			if (arg0[0].equals("DropItemOnReload"))
				dropItemOnReload = arg0[1];
			if (arg0[0].equals("DropItemOnHit"))
				dropItemOnHit = arg0[1];
		} catch (Exception e)
		{
			System.out.println("Reading bullet file failed.");
			e.printStackTrace();
		}
	}

	public static BulletType getBullet(String s)
	{
		for (BulletType bullet : bullets)
		{
			if (bullet.shortName.equals(s))
				return bullet;
		}
		return null;
	}

	public static BulletType getBullet(int id)
	{
		for (BulletType bullet : bullets)
		{
			if (bullet.itemID == id)
				return bullet;
		}
		return null;
	}
}
