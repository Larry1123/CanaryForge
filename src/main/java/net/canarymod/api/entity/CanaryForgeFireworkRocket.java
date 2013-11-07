package net.canarymod.api.entity;

import net.canarymod.api.inventory.Item;
import net.minecraft.entity.item.EntityFireworkRocket;

public class CanaryForgeFireworkRocket extends CanaryForgeEntity implements FireworkRocket {

    public CanaryForgeFireworkRocket(EntityFireworkRocket entityFireworkRocket) {
        super(entityFireworkRocket);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFqName() {
        return "FireworkRocket";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityType getEntityType() {
        return EntityType.FIREWORKROCKET;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Item getItem() {
        return null; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setItem(Item item) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLifeTime() {
        return 0; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLifeTime(int life) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLifeTimeMax() {
        return 0; // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLifeTimeMax(int life_time) {
        // TODO
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EntityFireworkRocket getHandle() {
        return (EntityFireworkRocket) entity;
    }

}
