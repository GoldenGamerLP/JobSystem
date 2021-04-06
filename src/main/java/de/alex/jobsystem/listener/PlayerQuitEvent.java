package de.alex.jobsystem.listener;

import de.alex.jobsystem.main.JobSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {

    @EventHandler
    public void onPlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent event) {
        JobSystem.getJobSystem().getJobPlayerManager().removePlayer(event.getPlayer());
    }

}
