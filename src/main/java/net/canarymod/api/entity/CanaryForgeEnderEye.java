package net.canarymod.api.entity;

import net.canarymod.api.world.position.Location;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderEye;

public class CanaryForgeEnderEye extends CanaryForgeEntity implements EnderEye {

    public CanaryForgeEnderEye(EntityEnderEye entityEnderEye) {
        super(entityEnderEye);
    }

    @Override
    public String getFqName() {
        return "EnderEye";
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.ENDEREYE;
    }

    @Override
    public double getTargetX() {
        return 0; // TODO
    }

    @Override
    public double getTargetY() {
        return 0; // TODO
    }

    @Override
    public double getTargetZ() {
        return 0; // TODO
    }

    @Override
    public void moveTowards(double targetX, int targetY, double targetZ) {
        // TODO
    }

    @Override
    public void moveTowards(Location location) {
        this.moveTowards(location.getX(), (int) location.getY(), location.getZ());
    }

    @Override
    public int getDespawnTimer() {
        return 0; // TODO
    }

    @Override
    public void setDespawnTimer(int despawn) {
        // TODO
    }

    @Override
    public boolean dropAfterDespawn() {
        return false; // TODO
    }

    @Override
    public void setDropAfterDespawn(boolean drop) {
        // TODO
    }

    @Override
    public EntityEnderEye getHandle() {
        return (EntityEnderEye) entity;
    }

}
