package de.alex.jobsystem.listener;

import de.alex.jobsystem.jobplayer.JobEnum;
import de.alex.jobsystem.jobplayer.JobPlayer;
import de.alex.jobsystem.main.JobSystem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

public class PlayerInventoryInteractEvent implements Listener {

    @EventHandler
    public void playerClickInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        JobPlayer jobPlayer = JobSystem.getJobSystem().getJobPlayerManager().addGetOrGet(player);
        if (event.getCurrentItem() == null && event.getCurrentItem().getType() == Material.AIR) return;
        switch (ChatColor.stripColor(event.getView().getTitle().toLowerCase())) {
            case "job coins abholen!":
                event.setResult(Event.Result.DENY);
                if (event.getCurrentItem().getType() == Material.GLOWSTONE_DUST)
                    jobPlayer.payOut();
                break;
            case "wähle ein job aus!":
                event.setResult(Event.Result.DENY);
                jobPlayer.changeJob(JobEnum.valueOf(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(JobSystem.getJobSystem().getKey(), PersistentDataType.STRING)));
                player.closeInventory();
                break;
            default:
                break;
        }
    }

}
