package me.rhys.plugin.packet.packets;

import org.bukkit.entity.Player;

public interface Packet {
    Object handlePacket(Player player, Object packet);
}
