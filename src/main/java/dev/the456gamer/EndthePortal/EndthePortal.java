package dev.the456gamer.EndthePortal;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class EndthePortal extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
    }

    @EventHandler
    public void onEntityPortal(final EntityPortalEvent event) {
        if (event.getFrom().getBlock().getType() == Material.END_PORTAL && event.getFrom().getWorld().getEnvironment() == World.Environment.THE_END)
            event.setCancelled(true);
    }

    @EventHandler
    public void onPlayerPortal(final PlayerPortalEvent event) {
        if (event.getFrom().getBlock().getType() == Material.END_PORTAL && event.getFrom().getWorld().getEnvironment() == World.Environment.THE_END)
            event.setCancelled(true);
    }
}
