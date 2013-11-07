package net.canarymod.api.entity;

import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.entity.projectile.EntityLargeFireball;

/**
 * Created with IntelliJ IDEA.
 * @author Larry1123
 * @since 11/7/13 - 3:15 AM
 */
public class CanaryForgeLargeFireball extends CanaryForgeFireball implements LargeFireball {

    private boolean damageWorld = true;
    private boolean damageEntity = true;

    /**
     * Constructs a new wrapper for EntityFireball
     *
     * @param entity the EntityFireball to be wrapped
     */
    public CanaryForgeLargeFireball(EntityLargeFireball entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityType getEntityType() {
        return EntityType.LARGEFIREBALL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFqName() {
        return "LargeFireball";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCanDamageWorld(boolean canDamage) {
        this.damageWorld = canDamage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canDamageWorld() {
        return this.damageWorld;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCanDamageEntities(boolean canDamage) {
        this.damageEntity = canDamage;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canDamageEntities() {
        return this.damageEntity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getPower() {
        // field may change keep watch
        return getHandle().field_92057_e;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPower(float power) {
        // field may change keep watch
        getHandle().field_92057_e = (int) power;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFuse() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFuse(int fuse) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void increaseFuse(int increase) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void decreaseFuse(int decrease) {}

    /**
     * {@inheritDoc}
     */
    @Override
    public void detonate() {
        // Look into this
        destroy();
        getHandle().worldObj.createExplosion(getHandle(), this.getX(), this.getY(), this.getZ(), getPower(), damageWorld);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLargeFireball getHandle() {
        return (EntityLargeFireball) entity;
    }

}
