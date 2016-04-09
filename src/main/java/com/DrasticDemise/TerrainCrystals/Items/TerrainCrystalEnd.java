package com.DrasticDemise.TerrainCrystals.Items;

import java.util.ArrayList;
import java.util.Random;

import com.DrasticDemise.TerrainCrystals.ConfigurationFile;

import net.minecraft.block.IGrowable;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TerrainCrystalEnd extends TerrainCrystalAbstract{
		public TerrainCrystalEnd(){
			setUnlocalizedName("terrainCrystalEnd");
			setRegistryName("terrainCrystalEnd");
			setCreativeTab(CreativeTabs.tabBlock);
			setHarvestLevel("stone", 0);
			setMaxStackSize(1);
			setMaxDamage(ConfigurationFile.endCrystalDurability);
	        GameRegistry.register(this);
		}
		@Override
		public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){
			super.gatherBlockGenList(itemStackIn, worldIn, playerIn, ConfigurationFile.endCrystalDiameter, Biomes.sky, ConfigurationFile.endCrystalChangesBiome);
			return new ActionResult(EnumActionResult.PASS, itemStackIn);
		}
		@Override
		protected int generateBlocksInWorld(BlockPos pos, World worldIn, EntityPlayer playerIn, int blocksGenerated,
				BiomeGenBase desiredBiome, boolean changeBiome){
			if(eligibleStateLocation(worldIn, pos)){
				int posY = MathHelper.floor_double(playerIn.posY);
				if(posY - pos.getY() == 1){
					worldIn.setBlockState(pos, Blocks.end_stone.getDefaultState());
					decoratePlatform(worldIn, pos);
					super.setBiome(worldIn, pos, desiredBiome, changeBiome);
				}else{
					worldIn.setBlockState(pos, Blocks.end_stone.getDefaultState());
				}
			}
			return blocksGenerated++;
		}
		
		@Override
		protected void decoratePlatform(World worldIn, BlockPos pos){
			//Chance to create a pillar
			if(ConfigurationFile.endCrystalGenerateObsidianSpikes && spacedFarEnough(worldIn, pos.up())){
				if(Math.random() < .02){
					worldIn.setBlockState(pos, Blocks.obsidian.getDefaultState());
					worldIn.setBlockState(pos.up(), Blocks.obsidian.getDefaultState());
					if(Math.random() < .9){
						worldIn.setBlockState(pos.up(2), Blocks.obsidian.getDefaultState());
						if(Math.random() < 0.9){
							worldIn.setBlockState(pos.up(3), Blocks.obsidian.getDefaultState());
							if(Math.random() < 0.7){
								worldIn.setBlockState(pos.up(4), Blocks.obsidian.getDefaultState());
								if(Math.random() < .75){
									worldIn.setBlockState(pos.up(4).north(), Blocks.obsidian.getDefaultState());
								}
								if(Math.random() < .75){
									worldIn.setBlockState(pos.up(4).east(), Blocks.obsidian.getDefaultState());
								}
								if(Math.random() < .75){
									worldIn.setBlockState(pos.up(4).south(), Blocks.obsidian.getDefaultState());
								}
								if(Math.random() < .75){
									worldIn.setBlockState(pos.up(4).west(), Blocks.obsidian.getDefaultState());
								}
								if(Math.random() < .25){
									worldIn.setBlockState(pos.up(5), Blocks.obsidian.getDefaultState());
									worldIn.setBlockState(pos.up(6), Blocks.obsidian.getDefaultState());
									if(Math.random() < .50){
										if(Math.random() < .75){
											worldIn.setBlockState(pos.up(5).north(), Blocks.obsidian.getDefaultState());
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).north(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).east(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).south(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).west(), Blocks.obsidian.getDefaultState());
											}
										}
										if(Math.random() < .75){
											worldIn.setBlockState(pos.up(5).east(), Blocks.obsidian.getDefaultState());
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).north(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).east(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).south(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).west(), Blocks.obsidian.getDefaultState());
											}
										}
										if(Math.random() < .75){
											worldIn.setBlockState(pos.up(5).south(), Blocks.obsidian.getDefaultState());
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).north(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).east(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).south(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).west(), Blocks.obsidian.getDefaultState());
											}
										}
										if(Math.random() < .75){
											worldIn.setBlockState(pos.up(5).west(), Blocks.obsidian.getDefaultState());
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).north(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).east(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).south(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).west(), Blocks.obsidian.getDefaultState());
											}
										}
										if(Math.random() < .5){
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).north(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).east(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).south(), Blocks.obsidian.getDefaultState());
											}
											if(Math.random() < .75){
												worldIn.setBlockState(pos.up(6).west(), Blocks.obsidian.getDefaultState());
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
