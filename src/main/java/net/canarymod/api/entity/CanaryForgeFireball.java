package net.canarymod.api.entity;

import net.canarymod.api.entity.living.EntityLiving;
import net.minecraft.entity.projectile.EntityFireball;

public abstract class CanaryForgeFireball extends CanaryForgeEntity implements Fireball {

    /**
     * Constructs a new wrapper for EntityFireball
     *
     * @param entity
     *            the EntityFireball to be wrapped
     */
    public CanaryForgeFireball(EntityFireball entity) {
        super(entity);
    }

    @Override
    public String getFqName() {
        return "Fireball";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTicksAlive() {
        return getHandle().ticksExisted;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTicksAlive(int ticks) {
        getHandle().ticksExisted = ticks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTicksInAir() {
        return 0; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTicksInAir(int ticks) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAccelerationX() {
        return getHandle().accelerationX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccelerationX(double accelX) {
        getHandle().accelerationX = accelX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAccelerationY() {
        return getHandle().accelerationY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccelerationY(double accelY) {
        getHandle().accelerationY = accelY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getAccelerationZ() {
        return getHandle().accelerationZ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccelerationZ(double accelZ) {
        getHandle().accelerationZ = accelZ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getMotionFactor() {
        return 0; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMotionFactor(float factor) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityLiving getOwner() {
        return null; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityFireball getHandle() {
        return (EntityFireball) entity;
    }

}
