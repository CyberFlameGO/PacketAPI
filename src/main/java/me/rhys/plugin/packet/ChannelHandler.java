package me.rhys.plugin.packet;

import org.bukkit.entity.Player;

public abstract class ChannelHandler {
    public abstract void injectPlayer(Player player);
    public abstract void removePlayer(Player player);
}
