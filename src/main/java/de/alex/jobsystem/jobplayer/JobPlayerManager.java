package de.alex.jobsystem.jobplayer;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class JobPlayerManager {

    private final HashMap<Player, JobPlayer> playerJobPlayerHashMap = new HashMap<>();

    public JobPlayer addGetOrGet(Player player) {
        if (!playerJobPlayerHashMap.containsKey(player)) {
            JobPlayer jobPlayer = new JobPlayer(JobEnum.NOJOB, player);
            playerJobPlayerHashMap.put(player, jobPlayer);
            return jobPlayer;
        }
        return playerJobPlayerHashMap.get(player);
    }

    public void removePlayer(Player player) {
        playerJobPlayerHashMap.remove(player);
    }

}
