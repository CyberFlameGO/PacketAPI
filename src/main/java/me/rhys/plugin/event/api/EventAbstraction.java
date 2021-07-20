package me.rhys.plugin.event.api;

import me.rhys.plugin.packet.packets.Packet;
import me.rhys.plugin.packet.packets.wrapped.WrappedPacket;
import org.bukkit.entity.Player;

public abstract class EventInterface {
    public abstract Object onPacket(Player player, WrappedPacket packet, Event.Direction direction);
}
