package com.BaileyHollingsworth.TerrainCrystals.Items.SkyCrystals;

import com.BaileyHollingsworth.TerrainCrystals.Items.TerrainCrystalAbstract;
import com.BaileyHollingsworth.TerrainCrystals.core.ConfigurationFile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

public class TerrainCrystalMesa extends TerrainCrystalAbstract{
	
	public TerrainCrystalMesa(){
		super("Mesa");
	}
	
	public TerrainCrystalMesa(boolean isGroundCrystal){
		super("Mesa", isGroundCrystal);
	}
	
	@Override
	protected int generateBlocksInWorld(BlockPos pos, World worldIn, EntityPlayer playerIn, int blocksGenerated,
										Biome desiredBiome, boolean changeBiome){
		if(eligibleStateLocation(worldIn, pos)){
			int posY = MathHelper.floor_double(playerIn.posY);
			int getMetaFromPlayerDistance = posY - pos.getY();
			if(posY - pos.getY() == 1){
				if(Math.random() < .7){
					worldIn.setBlockState(pos.down(), Blocks.HARDENED_CLAY.getDefaultState());
					worldIn.setBlockState(pos, Blocks.SAND.getStateFromMeta(1));
					if(!worldIn.isRemote)
						decoratePlatform(worldIn, pos);
				}else{
					if(Math.random() < .50){
						worldIn.setBlockState(pos, Blocks.DIRT.getDefaultState());
					}else{
						worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(1));
					}
				}
				setBiome(worldIn, pos, desiredBiome, changeBiome);
			}else{
				if(getMetaFromPlayerDistance == 2){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(getMetaFromPlayerDistance - 1));
				}else if (getMetaFromPlayerDistance == 3 || getMetaFromPlayerDistance == 4){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(4));
				}else if (getMetaFromPlayerDistance == 5 || getMetaFromPlayerDistance == 6){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(5));
				}else if (getMetaFromPlayerDistance == 7 || getMetaFromPlayerDistance == 8){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(7));
				}else if (getMetaFromPlayerDistance == 9 || getMetaFromPlayerDistance == 10){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(8));
				}else if (getMetaFromPlayerDistance == 11){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(getMetaFromPlayerDistance));
				}else if (getMetaFromPlayerDistance == 12){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(getMetaFromPlayerDistance));
				}else if (getMetaFromPlayerDistance == 13){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(getMetaFromPlayerDistance));
				}else if (getMetaFromPlayerDistance == 14){
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(getMetaFromPlayerDistance));
				}else{
					worldIn.setBlockState(pos, Blocks.STAINED_HARDENED_CLAY.getStateFromMeta(1));
				}
			}
			blocksGenerated += 1;
		}
		return blocksGenerated;
	}
	
	@Override
	protected void decoratePlatform(World worldIn, BlockPos pos){
		if(Blocks.CACTUS.canPlaceBlockAt(worldIn, pos.up())){
			if(Math.random() < .08){
				if(Math.random() < .5){
					worldIn.setBlockState(pos.up(), Blocks.CACTUS.getDefaultState());
					if(Math.random() < .5){
						worldIn.setBlockState(pos.up(2), Blocks.CACTUS.getDefaultState());
						if(Math.random() < .5){
							worldIn.setBlockState(pos.up(3), Blocks.CACTUS.getDefaultState());
						}
					}
				}else{
					worldIn.setBlockState(pos.up(), Blocks.DEADBUSH.getDefaultState());
				}
			}
		}
	}
	
	@Override
	protected Boolean changesBiomeOnUse() {
		return ConfigurationFile.mesaCrystalChangesBiome;
	}
	
	@Override
	protected Biome getBiomeType() {
		return Biomes.MESA;
	}
	
	@Override
	protected int getDiameter() {
		return ConfigurationFile.mesaCrystalDiameter;
	}
	
	@Override
	protected int getDurability() {
		return ConfigurationFile.mesaCrystalDurability;
	}
}