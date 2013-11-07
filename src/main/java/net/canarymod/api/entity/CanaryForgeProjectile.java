package net.canarymod.api.entity;

import net.minecraft.entity.IProjectile;
import net.minecraft.entity.Entity;

public abstract class CanaryForgeProjectile extends CanaryForgeEntity implements Projectile {

    public CanaryForgeProjectile(IProjectile entity) {
        super((Entity) entity);
    }

    @Override
    public void setProjectileHeading(double motionX, double motionY, double motionZ, float rotationYaw, float rotationPitch) {
        ((IProjectile) getHandle()).setThrowableHeading(motionX, motionY, motionZ, rotationYaw, rotationPitch);
    }
}
