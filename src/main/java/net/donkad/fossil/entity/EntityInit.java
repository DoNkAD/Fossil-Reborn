package net.donkad.fossil.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.donkad.fossil.FossilReborn.MODID;

public class EntityInit {

    public static final EntityType<StrulusEntity> STRULUS = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, StrulusEntity::new)
            .dimensions(EntityDimensions.fixed(1.00F, 1.64F)).build();

    public static final EntityType<BrachiosaurusEntity> BRACHIOSAURUS = FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BrachiosaurusEntity::new)
            .dimensions(EntityDimensions.fixed(1.0F, 1.0F)).build();

    public static void init(){
        //ENTITY_TYPE
        Registry.register(Registry.ENTITY_TYPE, new Identifier(MODID, "strulus"), STRULUS);
        Registry.register(Registry.ENTITY_TYPE, new Identifier(MODID, "brachiosaurus"), BRACHIOSAURUS);

        //ATTRIBUTES
        FabricDefaultAttributeRegistry.register(STRULUS, StrulusEntity.createAbstractDonkeyAttributes());
        FabricDefaultAttributeRegistry.register(BRACHIOSAURUS, BrachiosaurusEntity.createBrachiosaurusAttribute());
    }
}
