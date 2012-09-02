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
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import net.minecraft.src.*;
import net.minecraftforge.*;

@Mod(modid = "FlansMod", name = "Flan's Mod", version = "2.0")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class FlanMod implements ITickHandler
{
	@SidedProxy(clientSide = "flan.client.ClientProxy", serverSide = "flan.server.CommonProxy")
	public static CommonProxy proxy;
	
	@Init
	public void load(FMLInitializationEvent e)
	{
		System.out.println("Setting up FlansMod ...");
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
}
