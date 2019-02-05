package com.SmellyModder.TheLostSea.core.api.worlddata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.SmellyModder.TheLostSea.common.world.overworld.village.VillageGenNurmShop;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.storage.MapStorage;
import net.minecraft.world.storage.WorldSavedData;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

public class NurmWorldData {
	
	public static File file;
    private static String path = DimensionManager.getCurrentSaveRootDirectory() + "/lostseadata/overworld_data.txt";
    
    public static void writeFile()
    {
        file = new File(DimensionManager.getCurrentSaveRootDirectory() + "/lostseadata");
        if(!file.exists())
        file.mkdirs();
    }
    
    public static void useFileWriter()
            throws IOException 
    {
        int dataToWrite =  VillageGenNurmShop.spawned;
        
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(String.valueOf(dataToWrite));
        fileWriter.close();
        System.out.println("Writing Data To: " + path);
    }
    
    public static void setValueToOriginal()
            throws IOException 
    {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(String.valueOf(0));
        fileWriter.flush();
        fileWriter.close();
    }
    
    public static void readFile()
             throws FileNotFoundException 
    {
        file = new File(path);
        Scanner scanner = new Scanner(file);
        VillageGenNurmShop.spawned = scanner.nextInt();
        scanner.close();
    }
}
