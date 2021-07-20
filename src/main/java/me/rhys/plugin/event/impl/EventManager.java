package me.rhys.plugin.event.impl;

import lombok.Getter;
import me.rhys.plugin.event.api.Event;
import me.rhys.plugin.listener.PacketListener;

import java.util.ArrayList;
import java.util.List;

@Getter
public class EventManager {
    private final List<Event> eventList = new ArrayList<>();

    public void setup() {
        this.eventList.add(new PacketListener());
    }
}
