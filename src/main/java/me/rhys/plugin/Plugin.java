package me.rhys.plugin;

import lombok.Getter;
import me.rhys.plugin.listener.PlayerListener;
import me.rhys.plugin.packet.ChannelHandler;
import me.rhys.plugin.packet.impl.Instance1_8;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Getter
public class Plugin extends JavaPlugin {
    @Getter private static Plugin instance;

    private PlayerListener playerListener;

    private final ChannelHandler channelHandler = new Instance1_8();
    private final ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents((this.playerListener = new PlayerListener()), this);
    }

    @Override
    public void onDisable() {
        this.playerListener.removeAllPlayers();
        this.executorService.shutdownNow();
        instance = null;
    }
}
