package me.rhys.plugin.listener;

import me.rhys.plugin.event.api.Event;
import me.rhys.plugin.packet.packets.wrapped.WrappedPacket;
import me.rhys.plugin.packet.packets.wrapped.client.WrappedClientChatMessage;
import me.rhys.plugin.packet.packets.wrapped.server.WrappedServerChatMessage;
import org.bukkit.entity.Player;

public class PacketListener extends Event {

    @Override
    public Object onPacket(Player player, WrappedPacket packet, Direction direction) {

        if (packet instanceof WrappedClientChatMessage) {
            WrappedClientChatMessage wrappedClientChatMessage = (WrappedClientChatMessage) packet;
            wrappedClientChatMessage.setChatMessage(wrappedClientChatMessage.getChatMessage() + " [ARRIVED]");
        }

        if (packet instanceof WrappedServerChatMessage) {
            WrappedServerChatMessage wrappedServerChatMessage = (WrappedServerChatMessage) packet;
            wrappedServerChatMessage.setSentMessage(wrappedServerChatMessage.getSentMessage() + " [SENT]");
        }

        return packet;
    }
}
