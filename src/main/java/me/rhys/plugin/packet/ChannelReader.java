package me.rhys.plugin.packet;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import lombok.AllArgsConstructor;
import me.rhys.plugin.packet.packets.PacketHelper;
import org.bukkit.entity.Player;

@AllArgsConstructor
public class ChannelReader extends ChannelDuplexHandler {

    private final Player player;
    private final PacketHelper packetHelper = new PacketHelper();

    @Override
    public void channelRead(ChannelHandlerContext context, Object object) throws Exception {
        Object packet = this.packetHelper.handleClient(this.player, object);
        super.channelRead(context, packet);
    }

    @Override
    public void write(ChannelHandlerContext context, Object object, ChannelPromise channelPromise) throws Exception {
        Object packet = this.packetHelper.handleServer(player, object);
        super.write(context, packet, channelPromise);
    }
}
