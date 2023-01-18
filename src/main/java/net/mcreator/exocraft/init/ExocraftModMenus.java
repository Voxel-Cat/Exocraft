
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exocraft.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import net.mcreator.exocraft.world.inventory.ExostationGUIMenu;
import net.mcreator.exocraft.ExocraftMod;

public class ExocraftModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, ExocraftMod.MODID);
	public static final RegistryObject<MenuType<ExostationGUIMenu>> EXOSTATION_GUI = REGISTRY.register("exostation_gui",
			() -> IForgeMenuType.create(ExostationGUIMenu::new));
}
