package me.rhys.plugin.listener;

import me.rhys.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    public PlayerListener() {
        Bukkit.getServer().getOnlinePlayers().forEach(player -> Plugin.getInstance()
                .getChannelHandler().injectPlayer(player));
    }

    public void removeAllPlayers() {
        Bukkit.getServer().getOnlinePlayers().forEach(player -> Plugin.getInstance()
                .getChannelHandler().removePlayer(player));
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Plugin.getInstance().getChannelHandler().injectPlayer(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Plugin.getInstance().getChannelHandler().removePlayer(event.getPlayer());
    }
}
