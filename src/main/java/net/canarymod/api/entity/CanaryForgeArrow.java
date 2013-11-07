package net.canarymod.api.entity;

import net.minecraft.entity.projectile.EntityArrow;

public class CanaryForgeArrow extends CanaryForgeProjectile implements Arrow {

    public CanaryForgeArrow(EntityArrow entity) {
        super(entity);
    }

    @Override
    public boolean canPickUp() {
        return getHandle().canBePickedUp == 1;
    }

    @Override
    public void setCanPickUp(boolean canPickUp) {
        getHandle().canBePickedUp = canPickUp ? 1 : 0;
    }

    @Override
    public double getDamage() {
        return getHandle().getDamage();
    }

    @Override
    public void setDamage(double damage) {
        getHandle().setDamage(damage);
    }

    @Override
    public boolean isCritical() {
        return getHandle().getIsCritical();
    }

    @Override
    public void setIsCritical(boolean critical) {
        getHandle().setIsCritical(critical);
    }

    @Override
    public Entity getOwner() {
        return null; // TODO
    }

    @Override
    public boolean isInGround() {
        return false; // TODO
    }

    @Override
    public int getTicksInAir() {
        return 0; // TODO
    }

    @Override
    public int getTicksInGround() {
        return 0; // TODO
    }

    @Override
    public int getKnockbackStrength() {
        return 0; // TODO
    }

    @Override
    public void setKnockbackStrenth(int knockback) {
        getHandle().setKnockbackStrength(knockback);
    }

    @Override
    public String getFqName() {
        return "Arrow";
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.ARROW;
    }

    @Override
    public EntityArrow getHandle() {
        return (EntityArrow) entity;
    }

}
