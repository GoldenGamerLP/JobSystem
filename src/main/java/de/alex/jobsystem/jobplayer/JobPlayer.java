package de.alex.jobsystem.jobplayer;

import org.bukkit.entity.Player;

public class JobPlayer {

    private long lastPickUp = 0;
    private int currentJobCoins = 0;
    private int playerCoins = 0;
    private Player player;
    private JobEnum jobEnum;

    public JobPlayer(JobEnum jobEnum, Player player) {
        this.player = player;
        this.jobEnum = jobEnum;
    }

    public void payOut() {
        player.sendTitle("§6Jobs", String.format("§7%x wurden ausgezahlt", this.currentJobCoins), 10, 40, 10);
        this.playerCoins += this.currentJobCoins;
        this.currentJobCoins = 0;
    }

    public void changeJob(JobEnum jobEnum) {
        if (!jobEnum.equals(this.jobEnum)) {
            player.sendTitle("§6Jobs", String.format("§7Job geändert von %s zu %s", this.jobEnum.getJobName(), jobEnum.getJobName()), 10, 40, 10);
            this.jobEnum = jobEnum;
        } else player.sendTitle("§6Jobs", "§cDu hast bereits diesen Job!", 10, 40, 10);
    }

    //Getter and Setter

    public int getCurrentJobCoins() {
        return currentJobCoins;
    }

    public void setCurrentJobCoins(int currentJobCoins) {
        this.currentJobCoins = currentJobCoins;
    }

    public int getPlayerCoins() {
        return playerCoins;
    }

    public void setPlayerCoins(int playerCoins) {
        this.playerCoins = playerCoins;
    }

    public long getLastPickUp() {
        return lastPickUp;
    }

    public void setLastPickUp(long lastPickUp) {
        this.lastPickUp = lastPickUp;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public JobEnum getJobEnum() {
        return jobEnum;
    }
}
