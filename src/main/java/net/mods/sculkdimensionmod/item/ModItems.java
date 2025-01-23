package net.mods.sculkdimensionmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.entity.model.WitchEntityModel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mods.sculkdimensionmod.SculkDimensionMod;

public class ModItems
{
    public static final Item ALK_INGOT = registerItem("alk_ingot", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, Identifier.of(SculkDimensionMod.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        SculkDimensionMod.LOGGER.info("Registering mod items for " + SculkDimensionMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries ->
        {
            entries.add(ALK_INGOT);
        });
    }

}
