package crackpixel.org.skyblock;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CPUSkyblock extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(new PortalEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
