package com.github.gui1560.churruminium.block;

import java.util.function.Supplier;

import com.github.gui1560.churruminium.Churruminium;
import com.github.gui1560.churruminium.item.ModItems;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Churruminium.MOD_ID);

    public static final RegistryObject<Block> CHURRUMINIUM_BLOCK = registerBlock("churruminium_block",
    () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
    .strength(6f).requiresCorrectToolForDrops()), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> CHURRUMINIUM_ORE = registerBlock("churruminium_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
    .strength(6f).requiresCorrectToolForDrops(),
    UniformInt.of(1, 3)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> DEEPSLATE_CHURRUMINIUM_ORE = registerBlock("deepslate_churruminium_ore",
    () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
    .strength(6f).requiresCorrectToolForDrops(),
    UniformInt.of(1, 3)), CreativeModeTab.TAB_BUILDING_BLOCKS);

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
