package net.donkad.fossil.items.wands;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChargedRevivalWand extends RevivalWand {


    public ChargedRevivalWand(EntityType<? extends MobEntity> type, Settings settings) {
        super(type, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        PlayerEntity user = context.getPlayer();
        ItemStack itemStack = user.getMainHandStack();

        if (world.isClient()) {
            spawnParticles(context, pos);
        }

        if (!world.isClient() && !user.isSneaky()) {
            world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EVOKER_CAST_SPELL, SoundCategory.NEUTRAL, 0.5F, 0.4F / (context.getWorld().getRandom().nextFloat() * 0.4F + 0.8F));
        }
        return super.useOnBlock(context);
    }

    private void spawnParticles(ItemUsageContext pContext, BlockPos pos) {
        PlayerEntity user = pContext.getPlayer();
        if (!user.isSneaky()) {
            for (int i = 0; i < 360; i++) {
                if (i % 20 == 0) {
                    pContext.getWorld().addParticle(ParticleTypes.SOUL_FIRE_FLAME,
                            pos.getX() + 0.5, pos.getY() + 1.7, pos.getZ() + 0.5,
                            Math.cos(i) * 0.25d, 0.15d, Math.sin(i) * 0.25d);
                }
            }
        }
    }

    //Tooltip
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (Screen.hasShiftDown()) {
            tooltip.add(getEntityDesc());
        } else {
            tooltip.add(Text.translatable("item.fossil.charged_wand.tooltip"));
        }

    }

    public MutableText getEntityDesc() {
        return (Text.translatable(this.getTranslationKey() + ".shift"));
    }
}

