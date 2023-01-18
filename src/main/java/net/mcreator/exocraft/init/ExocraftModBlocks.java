
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exocraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import net.mcreator.exocraft.block.ExostationBlock;
import net.mcreator.exocraft.ExocraftMod;

public class ExocraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ExocraftMod.MODID);
	public static final RegistryObject<Block> EXOSTATION = REGISTRY.register("exostation", () -> new ExostationBlock());
}
