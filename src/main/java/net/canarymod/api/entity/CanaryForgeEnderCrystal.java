package net.canarymod.api.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;

import java.util.Random;

public class CanaryForgeEnderCrystal extends CanaryForgeEntity implements EnderCrystal {

    private final static Random random = new Random();
    private boolean damageWorld = true ;
    private boolean damageEntity = true;
    private boolean oneHit = true;
    private float power = 6.0F;

    public CanaryForgeEnderCrystal(EntityEnderCrystal entity) {
        super(entity);
    }

    @Override
    public String getFqName() {
        return "EnderCrystal";
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.ENDERCRYSTAL;
    }

    @Override
    public int getHealth() {
        return getHandle().health;
    }

    @Override
    public void setHealth(int health) {
        getHandle().health = health;
    }

    @Override
    public boolean isOneHitDetonate() {
        return oneHit;
    }

    @Override
    public void setOneHitDetonate(boolean oneHit) {
        this.oneHit = oneHit;
    }

    @Override
    public void setCanDamageWorld(boolean canDamage) {
        damageWorld = canDamage;
    }

    @Override
    public boolean canDamageWorld() {
        return damageWorld;
    }

    @Override
    public void setCanDamageEntities(boolean canDamage) {
        damageEntity = canDamage;
    }

    @Override
    public boolean canDamageEntities() {
        return damageEntity;
    }

    @Override
    public float getPower() {
        return power;
    }

    @Override
    public void setPower(float power) {
        this.power = power;
    }

    /**
     * There is no fuse
     *
     * @return Returns a random int just because
     */
    @Override
    public int getFuse() {
        return random.nextInt(Integer.MAX_VALUE);
    }

    /**
     * There is no fuse
     */
    @Override
    public void setFuse(int fuse) {}

    /**
     * There is no fuse
     */
    @Override
    public void increaseFuse(int increase) {}

    /**
     * There is no fuse
     */
    @Override
    public void decreaseFuse(int decrease) {}

    @Override
    public void detonate() {
        // Look into this
        destroy();
        getHandle().worldObj.createExplosion(getHandle(), this.getX(), this.getY(), this.getZ(), power, damageWorld);
    }

    @Override
    public EntityEnderCrystal getHandle() {
        return (EntityEnderCrystal) entity;
    }
}
