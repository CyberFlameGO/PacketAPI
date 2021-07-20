package me.rhys.plugin.packet.packets;

import me.rhys.plugin.packet.packets.client.PacketClientChat;
import me.rhys.plugin.packet.packets.server.PacketServerChat;
import net.minecraft.server.v1_8_R3.PacketPlayInChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.entity.Player;

public class PacketHelper {

    private final PacketClientChat packetClientChat = new PacketClientChat();
    private final PacketServerChat packetServerChat = new PacketServerChat();

    public Object handleServer(Player player, Object packet) {

        if (packet instanceof PacketPlayOutChat) {
            this.packetServerChat.handlePacket(player, packet);
        }

        return packet;
    }

    public Object handleClient(Player player, Object packet) {

        if (packet instanceof PacketPlayInChat) {
            return this.packetClientChat.handlePacket(player, packet);
        }

        return packet;
    }
}
