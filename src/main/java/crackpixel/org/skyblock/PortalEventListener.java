package crackpixel.org.skyblock;

import com.bgsoftware.superiorskyblock.api.SuperiorSkyblockAPI;
import com.bgsoftware.superiorskyblock.api.island.Island;
import com.bgsoftware.superiorskyblock.api.wrappers.SuperiorPlayer;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

import java.math.BigDecimal;
import java.util.Objects;

public class PortalEventListener implements Listener {
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
