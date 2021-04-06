package de.alex.jobsystem.listener;

import de.alex.jobsystem.jobplayer.JobPlayer;
import de.alex.jobsystem.main.JobSystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFishingEvent implements Listener {

    @EventHandler
    public void onPlayerFishEvent(PlayerFishEvent event) {
        if (!(event.getCaught() instanceof Player)) {
            JobPlayer jobPlayer = JobSystem.getJobSystem().getJobPlayerManager().addGetOrGet(event.getPlayer());
            switch (jobPlayer.getJobEnum()) {
                case FISHERMAN:
                    jobPlayer.setCurrentJobCoins(jobPlayer.getCurrentJobCoins() + jobPlayer.getJobEnum().getCoinsForATask());
                    break;
                default:
                    break;
            }
        }
    }

}
