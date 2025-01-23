package net.mods.sculkdimensionmod.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.mods.sculkdimensionmod.block.ModBlocks;
import net.mods.sculkdimensionmod.world.biome.ModBiomes;

public class ModMaterialRules
{

    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule SOULESS_STONE_BLOCK = makeStateRule(ModBlocks.SOULESS_STONE_BLOCK);


    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.SOULESS_PLAINS),
                                //em baixo
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, SOULESS_STONE_BLOCK)),
                                //superficie
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SOULESS_STONE_BLOCK)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }



}
