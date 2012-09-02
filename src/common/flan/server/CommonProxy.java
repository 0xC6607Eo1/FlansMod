package flan.server;

import java.util.Random;

import net.minecraft.src.*;

public abstract class CommonProxy
{
     public abstract void load();
     
     public abstract Object loadBulletModel(String[] arg0, String shortName);

     public abstract Object loadAAGunModel(String[] arg0, String shortName);

     public abstract Object loadMGModel(String[] arg0, String shortName);
}