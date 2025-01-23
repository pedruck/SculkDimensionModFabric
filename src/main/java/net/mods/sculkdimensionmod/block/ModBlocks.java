package net.mods.sculkdimensionmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.mods.sculkdimensionmod.SculkDimensionMod;

public class ModBlocks
{

    public static final Block SOULESS_STONE_BLOCK = registerBlock("souless_stone_block", new Block(AbstractBlock.Settings.create().strength(4f)
            .requiresTool().sounds(BlockSoundGroup.STONE)));


    private static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SculkDimensionMod.MOD_ID, name), block);
    }

    private static void  registerBlockItem(String name, Block block)
    {
        Registry.register(Registries.ITEM, Identifier.of(SculkDimensionMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks()
    {
        SculkDimensionMod.LOGGER.info("Registering Mod Blocks for " + SculkDimensionMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {


            entries.add(ModBlocks.SOULESS_STONE_BLOCK);





        });
    }
}
