package net.donkad.fossil.items;

import net.donkad.fossil.FossilReborn;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModTabs {
    public static final ItemGroup WANDS = FabricItemGroupBuilder.build(new Identifier(FossilReborn.MODID, "wands"),
            () -> new ItemStack(ItemsInit.STRULUS_REVIVAL_WAND));
}

