package net.canarymod.api.entity;

import net.canarymod.api.entity.living.Golem;
import net.canarymod.api.entity.living.LivingBase;
import net.canarymod.api.entity.living.animal.EntityAnimal;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.entity.living.monster.EntityMob;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.nbt.BaseTag;
import net.canarymod.api.nbt.CompoundTag;
import net.canarymod.api.world.World;
import net.canarymod.api.world.position.Location;
import net.canarymod.api.world.position.Position;
import net.canarymod.api.world.position.Vector3D;
import net.minecraft.entity.EntityLiving;

import java.util.UUID;

public abstract class CanaryForgeEntity implements Entity {

    protected net.minecraft.entity.Entity entity;

    public CanaryForgeEntity(net.minecraft.entity.Entity entity) {
        this.entity = entity;
    }

    @Override
    public double getX() {
        return getHandle().posX;
    }

    @Override
    public double getY() {
        return getHandle().posY;
    }

    @Override
    public double getZ() {
        return getHandle().posZ;
    }

    @Override
    public double getMotionX() {
        return getHandle().motionX;
    }

    @Override
    public double getMotionY() {
        return getHandle().motionY;
    }

    @Override
    public double getMotionZ() {
        return getHandle().motionZ;
    }

    @Override
    public float getPitch() {
        return getHandle().rotationPitch;
    }

    @Override
    public float getRotation() {
        return getHandle().rotationYaw;
    }

    @Override
    public Position getPosition() {
        return new Position(getX(), getY(), getZ());
    }

    @Override
    public Location getLocation() {
        return new Location(getWorld(), getX(), getY(), getZ(), getPitch(), getRotation());
    }

    @Override
    public int getID() {
        return getHandle().entityId;
    }

    @Override
    public UUID getUUID() {
        return getHandle().getUniqueID();
    }

    @Override
    public void setX(double x) {
        getHandle().posX = x;
    }

    @Override
    public void setX(int x) {
        getHandle().posX = x;
    }

    @Override
    public void setY(double y) {
        getHandle().posY = y;
    }

    @Override
    public void setY(int y) {
        getHandle().posY = y;
    }

    @Override
    public void setZ(double z) {
        getHandle().posZ = z;
    }

    @Override
    public void setZ(int z) {
        getHandle().posZ = z;
    }

    @Override
    public void setMotionX(double motionX) {
        getHandle().motionX = motionX;
    }

    @Override
    public void setMotionY(double motionY) {
        getHandle().motionY = motionY;
    }

    @Override
    public void setMotionZ(double motionZ) {
        getHandle().motionZ = motionZ;
    }

    @Override
    public void setPitch(float pitch) {
        getHandle().rotationPitch = pitch;
    }

    @Override
    public void setRotation(float rotation) {
        getHandle().rotationYaw = rotation;
    }

    @Override
    public Vector3D getMotion() {
        return null;
    }

    @Override
    public Vector3D getForwardVector() {
        return new Vector3D(getMotionX(), getMotionY(), getMotionZ());
    }

    @Override
    public void translate(Vector3D factor) {
        // TODO
    }

    @Override
    public void moveEntity(double motionX, double motionY, double motionZ) {
        getHandle().moveEntity(motionX, motionY, motionZ);
        // TODO maybe wrong
    }

    @Override
    public void teleportTo(double x, double y, double z) {
        teleportTo(x, y, z, 0.0F, 0.0F);
    }

    @Override
    public void teleportTo(double x, double y, double z, World world) {
        teleportTo(x, y, z, 0.0F, 0.0F, world);
    }

    @Override
    public void teleportTo(double x, double y, double z, float pitch, float rotation) {
        teleportTo(x, y, z, pitch, rotation, getWorld());
    }

    @Override
    public void teleportTo(double x, double y, double z, float pitch, float rotation, World dim) {
        if (dim != this.getWorld()) {
            // getHandle().setWorld(null); // TODO make that work
        }
        getHandle().setLocationAndAngles(x, y, z, 0.0F, 0.0F);
    }

    @Override
    public void teleportTo(Location location) {
        teleportTo(location.getX(), location.getY(), location.getZ(), location.getPitch(), location.getRotation(), location.getWorld());
    }

    @Override
    public void teleportTo(Position position) {
        teleportTo(position.getX(), position.getY(), position.getZ(), 0.0F, 0.0F);
    }

    @Override
    public World getWorld() {
        return null; // TODO
    }

    @Override
    public boolean isSprinting() {
        return getHandle().isSprinting();
    }

    @Override
    public void setSprinting(boolean sprinting) {
        getHandle().setSprinting(sprinting);
    }

    @Override
    public boolean isSneaking() {
        return getHandle().isSneaking();
    }

    @Override
    public void setSneaking(boolean sneaking) {
        getHandle().setSneaking(sneaking);
    }

    @Override
    public void setFireTicks(int ticks) {
        // TODO make it force set
        getHandle().setFire(ticks);
    }

    @Override
    public int getFireTicks() {
        return 0; // TODO
    }

    @Override
    public boolean isLiving() {
        return this instanceof LivingBase;
    }

    @Override
    public boolean isItem() {
        return this instanceof EntityItem;
    }

    @Override
    public boolean isMob() {
        return this instanceof EntityMob;
    }

    @Override
    public boolean isAnimal() {
        return this instanceof EntityAnimal;
    }

    @Override
    public boolean isPlayer() {
        return this instanceof Player;
    }

    @Override
    public boolean isGolem() {
        return this instanceof Golem;
    }

    @Override
    public EntityItem dropLoot(int itemId, int amount) {
        getHandle().dropItem(itemId, amount);
        return null; // TODO Return EntityItem
    }

    @Override
    public EntityItem dropLoot(Item item) {
        return null; // TODO
    }

    @Override
    public String getName() {
        return getHandle().getEntityName();
    }

    @Override
    public abstract String getFqName();

    @Override
    public boolean canSpawn() {
        return isLiving() && ((EntityLiving) getHandle()).getCanSpawnHere();
    }

    @Override
    public boolean spawn() {
        getHandle().setLocationAndAngles(getX() + 0.5d, getY(), getZ() + 0.5d, getRotation(), 0f);
        return getHandle().worldObj.spawnEntityInWorld(getHandle());
    }

    @Override
    public boolean spawn(Entity rider) {
        boolean ret = spawn();

        if (rider != null) {
            net.minecraft.entity.Entity mob2 = ((CanaryForgeEntity) rider).getHandle();
            mob2.setLocationAndAngles(getX(), getY(), getZ(), getRotation(), 0f);
            ret &= entity.worldObj.spawnEntityInWorld(mob2);
            mob2.mountEntity(getHandle());
        }
        return ret;
    }

    @Override
    public boolean isRiding() {
        return getHandle().isRiding();
    }

    @Override
    public boolean isRidden() {
        return getHandle().riddenByEntity != null;
    }

    @Override
    public Entity getRiding() {
        return null; // TODO
    }

    @Override
    public Entity getRider() {
        return null; // TODO
    }

    @Override
    public void setRider(Entity rider) {
        getHandle().mountEntity(((CanaryForgeEntity) rider).getHandle());
    }

    @Override
    public void destroy() {
        getHandle().setDead();
    }

    @Override
    public boolean isDead() {
        return !getHandle().isEntityAlive();
    }

    @Override
    public CompoundTag getNBT() {
        return null; // TODO
    }

    @Override
    public void setNBT(BaseTag tag) {
        // TODO
    }

    @Override
    public boolean isInvisible() {
        return getHandle().isInvisible();
    }

    @Override
    public void setInvisible(boolean invisible) {
        getHandle().setInvisible(invisible);
    }

    @Override
    public CompoundTag getMetaData() {
        return null; // TODO
    }

    /**
     * Gets the Minecraft entity being wrapped
     *
     * @return entity
     */
    public abstract net.minecraft.entity.Entity getHandle();

}
