package me.rhys.plugin.packet.packets.wrapped.client;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.rhys.plugin.packet.packets.wrapped.WrappedPacket;

@Getter @Setter
@AllArgsConstructor
public class WrappedClientChatMessage extends WrappedPacket {
    private String chatMessage;
}
