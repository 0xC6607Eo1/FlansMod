/**
 * TODO:
 * Add package addon [flan folder reader]
 * Nitro Model Thingy support
 * PlayerAPI [maybe ?]
 * Make more interaction between CommonProxy and ClientProxy.
 */

package flan.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import net.minecraft.src.*;
import net.minecraftforge.*;

@Mod(modid = "FlansMod", name = "Flan's Mod", version = "2.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class FlansMod implements ITickHandler
{
	@SidedProxy(clientSide = "flan.client.ClientProxy", serverSide = "flan.server.CommonProxy")
	public static CommonProxy proxy;
	
	@Init
	public void load(FMLInitializationEvent e)
	{
		log("Setting up FlansMod ...");
		TickRegistry.registerTickHandler(this, Side.SERVER);
		File flanDir = new File(FMLClientHandler.instance().getClient().getMinecraftDir() + "/Flan/");
		if(!flanDir.exists())
		{
			log("Flan folder not found. Creating empty folder.");
			log("You should get some content packs and put them in the Flan folder.");
			flanDir.mkdir();
			return;
		}
	}

	public void tickStart(EnumSet<TickType> type, Object... tickData) {}

	public void tickEnd(EnumSet<TickType> type, Object... tickData) 
	{
		if(type.equals(EnumSet.of(TickType.RENDER)))
        {
			//TODO: getClient
        }        
        if(type.equals(EnumSet.of(TickType.CLIENT)))
        {
        	//TODO: clientTick
        }
        if(type.equals(EnumSet.of(TickType.SERVER)))
        {
            //TODO: serverTick
        }
	}

	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.CLIENT, TickType.SERVER, TickType.RENDER);
	}

	public String getLabel() 
	{
		return null;
	}
	
	public static void log(String arg0)
	{
		System.out.println("Flan's Mod : " + arg0);
	}
}
