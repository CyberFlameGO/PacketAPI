package me.rhys.plugin.packet.packets.server;

import me.rhys.plugin.packet.packets.Packet;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.EnumChatFormat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.util.CraftChatMessage;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class PacketServerChat implements Packet {

    @Override
    public Object handlePacket(Player player, Object packet) {

        if (packet instanceof PacketPlayOutChat) {
            PacketPlayOutChat packetPlayOutChat = (PacketPlayOutChat) packet;

            try {
                Class<?> clazz = Class.forName(packetPlayOutChat.getClass().getName());

                BaseComponent[] components = packetPlayOutChat.components;
                TextComponent component;

                if (components != null) {
                    component = new TextComponent(components);
                } else {
                    Field field = clazz.getDeclaredField("a");
                    field.setAccessible(true);

                    IChatBaseComponent iChatBaseComponent = (IChatBaseComponent) field.get(packetPlayOutChat);

                    component = new TextComponent(CraftChatMessage.fromComponent(
                            iChatBaseComponent,
                            EnumChatFormat.WHITE));
                }

                packetPlayOutChat.components = TextComponent.fromLegacyText(component.toLegacyText() + " [SENT]");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
