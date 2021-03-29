package com.gildedgames.aether.common.item.accessories.gloves;

import com.gildedgames.aether.common.item.accessories.glove.GlovesItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class GoldGlovesItem extends GlovesItem
{
    public GoldGlovesItem(Properties properties, double damage) {
        super(properties, damage);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer) {
        return true;
    }
}
