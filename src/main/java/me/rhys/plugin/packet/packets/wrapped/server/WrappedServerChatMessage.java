package me.rhys.plugin.packet.packets.wrapped.server;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.rhys.plugin.packet.packets.wrapped.WrappedPacket;

@Getter @Setter
@AllArgsConstructor
public class WrappedServerChatMessage extends WrappedPacket {
    private String sentMessage;
}
