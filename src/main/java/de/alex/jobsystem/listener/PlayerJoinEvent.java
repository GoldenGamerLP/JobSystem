package de.alex.jobsystem.listener;

import de.alex.jobsystem.main.JobSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent event) {
        JobSystem.getJobSystem().getJobPlayerManager().addGetOrGet(event.getPlayer());
    }

}
