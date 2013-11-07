package net.canarymod.api;

import net.canarymod.Canary;
import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.gui.GUIControl;
import net.canarymod.api.inventory.recipes.CraftingRecipe;
import net.canarymod.api.inventory.recipes.Recipe;
import net.canarymod.api.inventory.recipes.SmeltRecipe;
import net.canarymod.api.world.World;
import net.canarymod.api.world.WorldManager;
import net.canarymod.api.world.blocks.CommandBlock;
import net.canarymod.hook.command.ConsoleCommandHook;
import net.canarymod.hook.system.PermissionCheckHook;
import net.canarymod.tasks.ServerTask;
import net.canarymod.tasks.ServerTaskManager;
import net.minecraft.network.TcpConnection;
import net.minecraft.network.packet.Packet201PlayerInfo;
import net.minecraft.server.MinecraftServer;
import net.visualillusionsent.utils.TaskManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanaryForgeServer implements Server {

    private static boolean headless;

    protected HashMap<String, ServerTimer> timers = new HashMap<String, ServerTimer>();
    private MinecraftServer server;
    String canaryVersion = null;
    private float tps = 20.0F;

    public CanaryForgeServer(MinecraftServer server) {
        this.server = server;
        addSynchronousTask(new TPSTracker(this));
    }

    @Override
    public String getHostname() {
        return getHandle().getHostname();
    }

    @Override
    public int getNumPlayersOnline() {
        return getHandle().getCurrentPlayerCount();
    }

    @Override
    public int getMaxPlayers() {
        return getHandle().getMaxPlayers();
    }

    @Override
    public String[] getPlayerNameList() {
        return getHandle().getAllUsernames();
    }

    @Override
    public ArrayList<Player> getPlayerList() {
        return null; // TODO
    }

    @Override
    public String getDefaultWorldName() {
        return getHandle().getWorldName();
    }

    @Override
    public WorldManager getWorldManager() {
        return null; // TODO
    }

    @Override
    public boolean consoleCommand(String command) {
        ConsoleCommandHook hook = new ConsoleCommandHook(this, command);

        Canary.hooks().callHook(hook);
        if (hook.isCanceled()) {
            return true;
        }
        String[] split = command.split(" ");
        if (!Canary.commands().parseCommand(this, split[0], split)) {
            return getHandle().getCommandManager().executeCommand(getHandle(), command) > 0; // Vanilla Commands passed
        }
        return true;
    }

    @Override
    public boolean consoleCommand(String command, Player player) {
        return false;  // TODO
    }

    @Override
    public boolean consoleCommand(String command, CommandBlock cmdBlock) {
        return false;  // TODO
    }

    @Override
    public void setTimer(String uniqueName, int time) {
        if (timers.containsKey(uniqueName)) {
            Canary.logWarning("Unique key timer " + uniqueName + " is already running, skipping.");
            return;
        }
        ServerTimer newTimer = new ServerTimer(uniqueName);
        TaskManager.scheduleDelayedTaskInSeconds(newTimer, time);
        timers.put(uniqueName, newTimer);
    }

    @Override
    public boolean isTimerExpired(String uniqueName) {
        return !timers.containsKey(uniqueName);
    }

    @Override
    public Player matchPlayer(String player) {
        return null; // TODO
    }

    @Override
    public OfflinePlayer getOfflinePlayer(String player) {
        return null; // TODO
    }

    @Override
    public Player getPlayer(String player) {
        return null; // TODO
    }

    @Override
    public void broadcastMessage(String message) {
        for (Player player : getPlayerList()) {
            player.message(message);
        }
    }

    @Override
    public boolean loadWorld(String name, long seed) {
        return false; // TODO
    }

    @Override
    public World getWorld(String name) {
        return null; // TODO
    }

    @Override
    public World getDefaultWorld() {
        return null; // TODO
    }

    @Override
    public String getName() {
        return "Console";
    }

    @Override
    public void notice(String message) {
        Canary.logNotice(message);
    }

    @Override
    public void message(String message) {
        Canary.logServerMessage(message);
    }

    @Override
    public boolean hasPermission(String node) {
        PermissionCheckHook hook = new PermissionCheckHook(node, this, true);
        Canary.hooks().callHook(hook);
        return hook.getResult();
    }

    @Override
    public boolean safeHasPermission(String permission) {
        return true;
    }

    @Override
    public ConfigurationManager getConfigurationManager() {
        getHandle().getConfigurationManager(); // TODO
        return null;
    }

    @Override
    public void initiateShutdown() {
        getHandle().initiateShutdown();
    }

    @Override
    public void restart(boolean reloadCanary) {
        // TODO
    }

    @Override
    public boolean isRunning() {
        return getHandle().isServerRunning();
    }

    @Override
    public Recipe addRecipe(CraftingRecipe recipe) {
        return null; // TODO
    }

    @Override
    public List<Recipe> getServerRecipes() {
        return null; // TODO
    }

    @Override
    public boolean removeRecipe(Recipe recipe) {
        return false; // TODO
    }

    @Override
    public void addSmeltingRecipe(SmeltRecipe recipe) {
        // TODO
    }

    @Override
    public List<SmeltRecipe> getServerSmeltRecipes() {
        return null; // TODO
    }

    @Override
    public boolean removeSmeltRecipe(SmeltRecipe recipe) {
        return false; // TODO
    }

    @Override
    public void addGUI(GUIControl gui) {
        // TODO
    }

    @Override
    public long[] getSentPacketCountArray() {
        return getHandle().sentPacketCountArray;
    }

    @Override
    public long[] getSentPacketSizeArray() {
        return getHandle().sentPacketSizeArray;
    }

    @Override
    public long[] getReceivedPacketCountArray() {
        return getHandle().receivedPacketCountArray;
    }

    @Override
    public long[] getReceivedPacketSizeArray() {
        return getHandle().receivedPacketSizeArray;
    }

    @Override
    public long[] getTickTimeArray() {
        return getHandle().tickTimeArray;
    }

    @Override
    public int getTcpReaderThreadCount() {
        // Need to keep an eye on this may change with version update
        return TcpConnection.field_74471_a.get();
    }

    @Override
    public int getTcpWriterThreadCount() {
        // Need to keep an eye on this may change with version update
        return TcpConnection.field_74469_b.get();
    }

    @Override
    public String getCanaryModVersion() {
        if (canaryVersion == null) {
            Package p = getClass().getPackage();
            if (p == null) {
                return "info missing!";
            }
            canaryVersion = p.getImplementationVersion();
        }
        return canaryVersion;
    }

    @Override
    public String getServerVersion() {
        return getHandle().getMinecraftVersion();
    }

    @Override
    public String getServerGUILog() {
        return null; // TODO
    }

    @Override
    public GUIControl getCurrentGUI() {
        return null; // TODO
    }

    @Override
    public boolean isHeadless() {
        return headless;
    }

    public void setHeadless(boolean head) {
        headless = head;
    }

    @Override
    public boolean addSynchronousTask(ServerTask task) {
        return ServerTaskManager.addTask(task);
    }

    @Override
    public boolean removeSynchronousTask(ServerTask task) {
        return ServerTaskManager.removeTask(task);
    }

    @Override
    public void sendPlayerListEntry(PlayerListEntry entry) {
        getHandle().getConfigurationManager().sendPacketToAllPlayers(new Packet201PlayerInfo(entry.getName(), entry.isShown(), entry.getPing()));
    }

    @Override
    public int getCurrentTick() {
        return getHandle().getTickCounter();
    }

    @Override
    public float getTicksPerSecond() {
        return tps;
    }

    public class ServerTimer implements Runnable {
        private String name;

        public ServerTimer(String name) {
            this.name = name;
        }

        @Override
        public synchronized void run() {
            timers.remove(name);
        }
    }

    /**
     * The internal CanaryServer Tick monitor task.
     * Used to track ticks per second.
     *
     * @author Jason (darkdiplomat)
     */
    private final class TPSTracker extends ServerTask {
        private long tpsSpan = System.currentTimeMillis();
        private int startTick = getCurrentTick();

        private TPSTracker(CanaryForgeServer server) {
            super(server, 20L, true); // Run once every 20 ticks
        }

        @Override
        public final void onReset() {
            this.tpsSpan = System.currentTimeMillis();
            this.startTick = getCurrentTick();
        }

        @Override
        public final void run() {
            long timeSpan = System.currentTimeMillis() - tpsSpan;
            int ticks = getCurrentTick() - startTick;
            tps = (float) ticks / ((float) timeSpan / 1000.0F);
        }
    }

    public MinecraftServer getHandle() {
        return server;
    }
}
