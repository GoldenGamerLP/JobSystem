package de.alex.jobsystem.listener;

import de.alex.jobsystem.jobplayer.JobEnum;
import de.alex.jobsystem.jobplayer.JobPlayer;
import de.alex.jobsystem.main.JobSystem;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBlockBreakEvent implements Listener {

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        JobPlayer jobPlayer = JobSystem.getJobSystem().getJobPlayerManager().addGetOrGet(event.getPlayer());
        if (jobPlayer.getJobEnum().equals(JobEnum.NOJOB)) return;
        switch (jobPlayer.getJobEnum()) {
            case MINER:
                jobPlayer.setCurrentJobCoins(jobPlayer.getCurrentJobCoins() + jobPlayer.getJobEnum().getCoinsForATask());
                break;
            default:
                break;
        }
    }

}
