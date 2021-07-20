package me.rhys.plugin.packet.packets.client;

import me.rhys.plugin.Plugin;
import me.rhys.plugin.event.api.Event;
import me.rhys.plugin.packet.packets.Packet;
import me.rhys.plugin.packet.packets.wrapped.client.WrappedClientChatMessage;
import net.minecraft.server.v1_8_R3.PacketPlayInChat;
import org.bukkit.entity.Player;

public class PacketClientChat implements Packet {

    @Override
    public Object handlePacket(Player player, Object packet) {

        if (packet instanceof PacketPlayInChat) {
            PacketPlayInChat packetPlayInChat = (PacketPlayInChat) packet;
            final String[] chatMessage = {packetPlayInChat.a()};

            Plugin.getInstance().getEventManager().getEventList().forEach(event -> {
                Object obj = event.onPacket(player, new WrappedClientChatMessage(chatMessage[0]),
                        Event.Direction.CLIENT);

                if (obj instanceof WrappedClientChatMessage) {
                    WrappedClientChatMessage wrappedClientChatMessage = (WrappedClientChatMessage) obj;
                    chatMessage[0] = wrappedClientChatMessage.getChatMessage();
                }
            });

            return new PacketPlayInChat(chatMessage[0]);
        }

        return packet;
    }
}
