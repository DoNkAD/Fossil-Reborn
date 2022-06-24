package net.donkad.fossil.items;

import net.donkad.fossil.entity.EntityInit;
import net.donkad.fossil.items.wands.ChargedRevivalWand;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import static net.donkad.fossil.FossilReborn.MODID;

public class ItemsInit {

    //FOSSIL
    public static final Item STRULUS_FOSSIL = registerModFossil("strulus_fossil");

    //FRAGMENT ESSENCE
    public static final Item STRULUS_FRAGMENT_ESSENCE = registerModEssence("strulus_fragment_essence");

    //ESSENCE
    public static final Item STRULUS_ESSENCE = registerModEssence("strulus_essence");

    // Wands
    public static final Item REVIVAL_WAND = registerItems("revival_wand",
            new Item(new Item.Settings().group(ModTabs.WANDS)));

    //CHARGED WANDS
    public static final Item STRULUS_REVIVAL_WAND = registerItems("strulus_revival_wand",
            new ChargedRevivalWand(EntityInit.STRULUS, new Item.Settings().rarity(Rarity.EPIC).maxDamage(1).group(ModTabs.WANDS)));

    // Register stuff
    private static Item registerModFossil(String name) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name),
                new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON).group(ItemGroup.MISC)));
    }

    private static Item registerModEssence(String name) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name),
                new Item(new FabricItemSettings().rarity(Rarity.RARE).group(ItemGroup.MISC)));
    }

    private static  Item registerItems(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MODID, name), item);
    }
    public static void init() {}
}
