package net.canarymod.api.entity;

import net.canarymod.api.world.blocks.BlockType;
import net.minecraft.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingSand;

public class CanaryForgeFallingBlock extends CanaryForgeEntity implements FallingBlock {

    public CanaryForgeFallingBlock(EntityFallingSand entityFallingSand) {
        super(entityFallingSand);
    }

    @Override
    public String getFqName() {
        return "FallingBlock";
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.FALLINGBLOCK;
    }

    @Override
    public short getBlockID() {
        return (short) getHandle().blockID;
    }

    @Override
    public void setBlockID(short id) {
        if (BlockType.fromId(id) != null) { // Safety
            getHandle().blockID = id;
        }
    }

    @Override
    public short getBlockMetaData() {
        return (short) getHandle().metadata;
    }

    @Override
    public void setBlockMetaData(short data) {
        getHandle().metadata = data;
    }

    @Override
    public int getFallTime() {
        return getHandle().fallTime;
    }

    @Override
    public void setFallTime(int fallTime) {
        getHandle().fallTime = fallTime;
    }

    @Override
    public boolean dropsItem() {
        return getHandle().shouldDropItem;
    }

    @Override
    public void setDropsItem(boolean drops) {
        getHandle().shouldDropItem = drops;
    }

    @Override
    public boolean isBreakingAnvil() {
        return false; // TODO
    }

    @Override
    public void setIsBreakingAnvil(boolean breaking) {
        // TODO
    }

    @Override
    public boolean hurtEntities() {
        return false;
    }

    @Override
    public void setHurtEntities(boolean hurt) {
        // TODO
    }

    @Override
    public int getMaxDamage() {
        return 0; // TODO
    }

    @Override
    public void setMaxDamage(int max) {
        // TODO
    }

    @Override
    public float getDamageAmount() {
        return 0; // TODO
    }

    @Override
    public void setDamageAmount(float damage) {
        // TODO
    }

    @Override
    public EntityFallingSand getHandle() {
        return (EntityFallingSand) entity;
    }

}
