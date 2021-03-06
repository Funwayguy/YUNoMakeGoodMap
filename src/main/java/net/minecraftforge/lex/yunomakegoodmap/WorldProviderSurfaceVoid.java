package net.minecraftforge.lex.yunomakegoodmap;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldProviderSurface;
import net.minecraft.world.chunk.IChunkGenerator;

public class WorldProviderSurfaceVoid extends WorldProviderSurface
{
    @Override
    public boolean canCoordinateBeSpawn(int x, int z)
    {
        if (YUNoMakeGoodMap.instance.shouldBeVoid(worldObj))
            return true;
        return super.canCoordinateBeSpawn(x, z);
    }

    @Override
    public BlockPos getRandomizedSpawnPoint()
    {
        if (YUNoMakeGoodMap.instance.shouldBeVoid(worldObj))
        {
            BlockPos spawn = new BlockPos(worldObj.getSpawnPoint());
            spawn = worldObj.getTopSolidOrLiquidBlock(spawn);
            return spawn;
        }
        else
        {
            return super.getRandomizedSpawnPoint();
        }
    }

    @Override
    protected void createBiomeProvider()
    {
        if (YUNoMakeGoodMap.instance.shouldBeVoid(worldObj))
        	biomeProvider = new VoidWorldChunkManager(worldObj);
        else
        	super.createBiomeProvider();
    }

    @Override
    public IChunkGenerator createChunkGenerator()
    {
        if (YUNoMakeGoodMap.instance.shouldBeVoid(worldObj))
            return new ChunkProviderFlatVoid(worldObj);
        return super.createChunkGenerator();
    }
}
