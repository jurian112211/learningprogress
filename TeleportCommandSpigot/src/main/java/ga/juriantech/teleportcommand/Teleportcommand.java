package ga.juriantech.teleportcommand;

import co.aikar.commands.BukkitCommandManager;
import ga.juriantech.teleportcommand.commands.TeleportLoc;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class Teleportcommand extends JavaPlugin {

    public Logger logger = Bukkit.getLogger();
    Teleportcommand plugin;
    private static Teleportcommand instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        commands();
        config();
        logger.warning("TeleportCommand has been started!");
    }

    private void config() {
        plugin.saveDefaultConfig();
    }

    private void commands() {
        BukkitCommandManager manager = new BukkitCommandManager(plugin);
        manager.registerCommand(new TeleportLoc());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.warning("TeleportCommand successfully stopped!");
    }
    public static Teleportcommand getInstance() {
        return instance;
    }
}
