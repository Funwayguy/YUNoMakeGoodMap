package net.minecraftforge.lex.yunomakegoodmap;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;

public class VoidWorldType extends WorldType
{
    public VoidWorldType()
    {
        super("void");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world)
    {
        return new VoidWorldChunkManager(world);
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions)
    {
        return new ChunkProviderFlatVoid(world);
    }
    
    @Override
    public int getSpawnFuzz(WorldServer world, MinecraftServer server)
    {
    	return 1;
    }
}
