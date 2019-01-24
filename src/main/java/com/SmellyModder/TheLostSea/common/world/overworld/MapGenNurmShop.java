package com.SmellyModder.TheLostSea.common.world.overworld;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.init.Biomes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureStart;
import net.minecraft.world.gen.structure.StructureVillagePieces;

public class MapGenNurmShop  extends MapGenStructure
{
    /** A list of all the biomes villages can spawn in. */
    public static List<Biome> VILLAGE_SPAWN_BIOMES = Arrays.<Biome>asList(Biomes.BEACH, Biomes.PLAINS, Biomes.FOREST);
    private int size;
    private int averageSpacing;
    
    public MapGenNurmShop()
    {
        averageSpacing = 12;
    }

    public MapGenNurmShop(Map<String, String> map)
    {
        this();

        for (Entry<String, String> entry : map.entrySet())
        {
            if (entry.getKey().equals("size"))
            {
                size = MathHelper.getInt(entry.getValue(), size, 0);
            }
            else if (entry.getKey().equals("distance"))
            {
                averageSpacing = MathHelper.getInt(entry.getValue(), averageSpacing, 9);
            }
        }
    }

    /*
     * @see net.minecraft.world.gen.structure.MapGenStructure#getStructureName()
     */
    @Override
    public String getStructureName()
    {
        return "Nurm's Shop";
    }

    /*
     * @see net.minecraft.world.gen.structure.MapGenStructure#canSpawnStructureAtCoords(int, int)
     */
    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ)
    {
        int unadjustedX = chunkX;
        int unadjustedZ = chunkZ;

        if (chunkX < 0)
        {
            chunkX -= averageSpacing - 1;
        }

        if (chunkZ < 0)
        {
            chunkZ -= averageSpacing - 1;
        }

        // randomize relative positions of village candidate sites
        int candidateX = chunkX / averageSpacing;
        int candidateZ = chunkZ / averageSpacing;
        Random random = world.setRandomSeed(candidateX, candidateZ, 10387312);
        candidateX = candidateX * averageSpacing;
        candidateZ = candidateZ * averageSpacing;
        candidateX = candidateX + random.nextInt(averageSpacing - 8);
        candidateZ = candidateZ + random.nextInt(averageSpacing - 8);

        if (unadjustedX == candidateX && unadjustedZ == candidateZ)
        {
            System.out.println("Is biome viable for village = " + world.getBiomeProvider().areBiomesViable(unadjustedX * 16 + 8, unadjustedZ * 16 + 8, 0, VILLAGE_SPAWN_BIOMES));
            return world.getBiomeProvider().areBiomesViable(unadjustedX * 16 + 8, unadjustedZ * 16 + 8, 0, VILLAGE_SPAWN_BIOMES);
        }

        return false;
    }
    
    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored)
    {
        world = worldIn;
        return findNearestStructurePosBySpacing(worldIn, this, pos, averageSpacing, 8, 10387312, false, 100, findUnexplored);
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ)
    {
        return new MapGenNurmShop.Start(world, rand, chunkX, chunkZ, size);
    }

    public static class Start extends StructureStart
    {
            private boolean hasMoreThanTwoComponents;

            public Start()
            {
            }

            /**
             * Instantiates a new start.
             *
             * @param worldIn the world in
             * @param rand the rand
             * @param x the x
             * @param z the z
             * @param size the size
             */
            public Start(World worldIn, Random rand, int x, int z, int size)
            {
                super(x, z);
                List<StructureVillagePieces.PieceWeight> list = StructureVillagePieces.getStructureVillageWeightedPieceList(rand, size);
                StructureVillagePieces.Start start = new StructureVillagePieces.Start(worldIn.getBiomeProvider(), 0, rand, (x << 4) + 2, (z << 4) + 2, list, size);
                components.add(start);
                start.buildComponent(start, components, rand);
                List<StructureComponent> pendingRoads = start.pendingRoads;
                List<StructureComponent> pendingHouses = start.pendingHouses;

                while (!pendingRoads.isEmpty() || !pendingHouses.isEmpty())
                {
                    if (pendingRoads.isEmpty())
                    {
                        int i = rand.nextInt(pendingHouses.size());
                        StructureComponent component = pendingHouses.remove(i);
                        component.buildComponent(start, components, rand);
                    }
                    else
                    {
                        int j = rand.nextInt(pendingRoads.size());
                        StructureComponent component = pendingRoads.remove(j);
                        component.buildComponent(start, components, rand);
                    }
                }

                updateBoundingBox();
                int nonRoadComponentCount = 0;

                for (StructureComponent component : components)
                {
                    if (!(component instanceof StructureVillagePieces.Road))
                    {
                        ++nonRoadComponentCount;
                    }
                }

                hasMoreThanTwoComponents = nonRoadComponentCount > 2;
            }

            @Override
            public boolean isSizeableStructure()
            {
                return hasMoreThanTwoComponents;
            }

            @Override
            public void writeToNBT(NBTTagCompound tagCompound)
            {
                super.writeToNBT(tagCompound);
                tagCompound.setBoolean("Valid", hasMoreThanTwoComponents);
            }
            
            @Override
            public void readFromNBT(NBTTagCompound tagCompound)
            {
                super.readFromNBT(tagCompound);
                hasMoreThanTwoComponents = tagCompound.getBoolean("Valid");
            }
        }
}
