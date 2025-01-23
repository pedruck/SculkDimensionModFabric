package net.mods.sculkdimensionmod.world.biome;

import net.minecraft.util.Identifier;
import net.mods.sculkdimensionmod.SculkDimensionMod;
import net.mods.sculkdimensionmod.world.biome.surface.ModMaterialRules;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi
{
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(Identifier.of(SculkDimensionMod.MOD_ID, "overworld"), RegionType.OVERWORLD, 5));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, SculkDimensionMod.MOD_ID, ModMaterialRules.makeRules());
    }
}
