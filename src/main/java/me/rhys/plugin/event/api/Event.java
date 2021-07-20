package me.rhys.plugin.event.api;

import me.rhys.plugin.packet.packets.Packet;
import me.rhys.plugin.packet.packets.wrapped.WrappedPacket;
import org.bukkit.entity.Player;

public class Event extends EventInterface {

    @Override
    public Object onPacket(Player player, WrappedPacket packet, Direction direction) {
        return packet;
    }

    public enum Direction {
        CLIENT,
        SERVER
    }
}
