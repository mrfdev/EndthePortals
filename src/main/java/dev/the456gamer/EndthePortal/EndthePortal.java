package dev.the456gamer.EndthePortal;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class EndthePortal extends JavaPlugin implements Listener {
    Logger logger;
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.logger = this.getLogger();
        this.getServer().getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler //TODO: this doesnt work on exitin the end. entering is fine, but not exit.
    public void onPortal(PlayerPortalEvent event) { //the event isnt called, so maybe another event?
        logger.info("got player teleport "+event.getPlayer()+";"+event.getCause()+";"+event.getFrom().getBlock());
        if (event.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)
                && event.getFrom().getWorld().getEnvironment()
                .equals(World.Environment.THE_END)) {
            event.setCancelled(true);
            logger.info("prevented "+event.getPlayer().getName()+" from entering portal at "+event.getFrom());

        }
    }

    @EventHandler
    public void onEntityPortal(EntityPortalEvent event){
        //logger.info("got entity portal event " + event.getEntity() + ";" + event.getFrom().getWorld() + ";" + event.getFrom().getBlock());
        if (event.getFrom().getBlock().getType().equals(Material.END_PORTAL)
                && event.getFrom().getWorld().getEnvironment()
                .equals(World.Environment.THE_END)) {
            event.setCancelled(true);
            //logger.info("prevented "+event.getEntity()+" from entering portal at "+event.getFrom());

        }
    }


}
