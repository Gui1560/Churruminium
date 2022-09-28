package com.github.gui1560.churruminium.item;

import com.github.gui1560.churruminium.Churruminium;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = 
            DeferredRegister.create(ForgeRegistries.ITEMS, Churruminium.MOD_ID);

        public static final RegistryObject<Item> CHURRUMINIUM_INGOT = ITEMS.register("churruminium_ingot",
        () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MATERIALS)));

        public static void register(IEventBus eventBus) {
             ITEMS.register(eventBus);
        }
}