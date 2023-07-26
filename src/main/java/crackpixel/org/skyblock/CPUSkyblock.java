package crackpixel.org.skyblock;

import java.math.BigDecimal;

import org.bukkit.Bukkit;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.bgsoftware.superiorskyblock.api.SuperiorSkyblockAPI;
import com.bgsoftware.superiorskyblock.api.island.Island;
import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;

public final class CPUSkyblock extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPortal(PlayerPortalEvent portalEvent) {
        Player p = portalEvent.getPlayer();
        if (SuperiorSkyblockAPI.getPlayer(p).hasIsland()) {
            Island i = SuperiorSkyblockAPI.getIsland(p.getName());
            SuperiorSkyblockAPI.getPlayer(p).teleport(i);
        } else {
            SuperiorPlayer sp = SuperiorSkyblockAPI.getPlayer(p);
            SuperiorSkyblockAPI.createIsland(sp, "normal", new BigDecimal("0"), Biome.PLAINS, p.getName());
        }
    }
}
