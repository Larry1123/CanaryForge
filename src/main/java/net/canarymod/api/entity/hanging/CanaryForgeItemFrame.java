package net.canarymod.api.entity.hanging;

import net.canarymod.api.entity.EntityType;
import net.canarymod.api.inventory.Item;
import net.minecraft.entity.item.EntityItemFrame;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Larry1123
 * @since 11/7/13 - 3:44 AM
 */
public class CanaryForgeItemFrame extends CanaryForgeHangingEntity implements ItemFrame {

    /**
     * Constructs a new wrapper for EntityItemFrame
     *
     * @param entity
     *            the EntityItemFrame to be wrapped
     */
    public CanaryForgeItemFrame(EntityItemFrame entity) {
        super(entity);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFqName() {
        return "ItemFrame";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityType getEntityType() {
        return EntityType.ITEMFRAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item getItemInFrame() {
        return null; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setItemInFrame(Item item) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemRotation() {
        return getHandle().getRotation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setItemRotation(int rot) {
        getHandle().setItemRotation(rot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getItemDropChance() {
        return 0; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setItemDropChance(float chance) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityItemFrame getHandle() {
        return (EntityItemFrame) entity;
    }

}
