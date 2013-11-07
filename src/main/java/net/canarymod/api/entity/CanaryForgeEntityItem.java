package net.canarymod.api.entity;

import net.canarymod.api.inventory.Item;

public class CanaryForgeEntityItem extends CanaryForgeEntity implements EntityItem {

    public CanaryForgeEntityItem(net.minecraft.entity.item.EntityItem entity) {
        super(entity);
    }

    @Override
    public String getFqName() {
        return "Item";
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.ENTITYITEM;
    }

    @Override
    public void setAge(short age) {
        getHandle().age = age;
    }

    @Override
    public short getAge() {
        return (short) getHandle().age;
    }

    @Override
    public int getPickUpDelay() {
        return getHandle().delayBeforeCanPickup;
    }

    @Override
    public void setPickUpDelay(int delay) {
        getHandle().delayBeforeCanPickup = delay;
    }

    @Override
    public short getHealth() {
        return 0; // TODO
    }

    @Override
    public void setHealth(short health) {

    }

    @Override
    public Item getItem() {
        return null; // TODO
    }

    @Override
    public void setItem(Item item) {
        // TODO
    }

    @Override
    public net.minecraft.entity.item.EntityItem getHandle() {
        return (net.minecraft.entity.item.EntityItem) entity;
    }

}
