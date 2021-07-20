package me.rhys.plugin.packet.impl;

import io.netty.channel.Channel;
import me.rhys.plugin.Plugin;
import me.rhys.plugin.packet.ChannelHandler;
import me.rhys.plugin.packet.ChannelReader;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Instance1_8 extends ChannelHandler {

    private final String channelInjectionName = "PacketAPI";

    @Override
    public void injectPlayer(Player player) {
        Plugin.getInstance().getExecutorService().execute(() -> {
            Channel nsmChannel = this.getNsmChannel(player);
            ChannelReader channelReader = (ChannelReader) nsmChannel.pipeline().get(this.channelInjectionName);

            if (channelReader == null) {
                channelReader = new ChannelReader(player);

                if (nsmChannel.pipeline().get(this.channelInjectionName) != null) {
                    nsmChannel.pipeline().remove(this.channelInjectionName);
                }

                nsmChannel.pipeline().addBefore(
                        "packet_handler",
                        this.channelInjectionName,
                        channelReader
                );
            }
        });
    }

    @Override
    public void removePlayer(Player player) {
        Plugin.getInstance().getExecutorService().execute(() -> {
            Channel nsmChannel = this.getNsmChannel(player);

            nsmChannel.eventLoop().execute(() -> {
                if (nsmChannel.pipeline().get(this.channelInjectionName) != null) {
                    nsmChannel.pipeline().remove(this.channelInjectionName);
                }
            });
        });
    }

    Channel getNsmChannel(Player player) {
        CraftPlayer craftPlayer = ((CraftPlayer) player);
        return craftPlayer.getHandle().playerConnection.networkManager.channel;
    }
}
