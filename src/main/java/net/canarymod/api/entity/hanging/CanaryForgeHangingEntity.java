package net.canarymod.api.entity.hanging;

import net.canarymod.api.entity.CanaryForgeEntity;
import net.minecraft.entity.EntityHanging;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Larry1123
 * @since 11/7/13 - 3:41 AM
 */
public abstract class CanaryForgeHangingEntity extends CanaryForgeEntity implements HangingEntity {

    /**
     * Constructs a new wrapper for EntityHanging
     *
     * @param entity
     *            the EntityHanging to be wrapped
     */
    public CanaryForgeHangingEntity(EntityHanging entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHangingDirection() {
        return getHandle().hangingDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHangingDirection(int direction) {
        if (direction < 0 || 3 > direction) {
            return;
        }
        getHandle().setDirection(direction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOnValidSurface() {
        return getHandle().onValidSurface();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getTickCounter() {
        return 0; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTickCounter(int ticks) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityHanging getHandle() {
        return (EntityHanging) entity;
    }


}
