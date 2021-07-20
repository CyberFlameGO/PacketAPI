package me.rhys.plugin.packet.packets.client;

import me.rhys.plugin.packet.packets.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayInChat;
import org.bukkit.entity.Player;

public class PacketClientChat implements Packet {

    @Override
    public Object handlePacket(Player player, Object packet) {

        if (packet instanceof PacketPlayInChat) {
            PacketPlayInChat packetPlayInChat = (PacketPlayInChat) packet;
            String chatMessage = packetPlayInChat.a();

            return new PacketPlayInChat(chatMessage + " [ARRIVED]");
        }

        return packet;
    }
}
