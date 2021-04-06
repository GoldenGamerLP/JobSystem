package de.alex.jobsystem.inventorys;

import de.alex.jobsystem.jobplayer.JobEnum;
import de.alex.jobsystem.main.JobSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.Arrays;

public class JobSelectorInventory {

    private final Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "§bWähle ein Job aus!");

    public void initInventory() {
        inventory.setItem(13, getJobItem(JobEnum.MINER, Material.IRON_PICKAXE));
        inventory.setItem(15, getJobItem(JobEnum.FISHERMAN, Material.TROPICAL_FISH));
    }

    private ItemStack getJobItem(JobEnum jobEnum, Material material) {
        ItemStack jobItem = new ItemStack(material, 1);
        ItemMeta jobItemItemMeta = jobItem.getItemMeta();
        assert jobItemItemMeta != null;
        jobItemItemMeta.setDisplayName("§6" + jobEnum.getJobName());
        jobItemItemMeta.setLore(Arrays.asList("§7", String.format("§7Klicke hier um den Job %s auszuwählen", jobEnum.getJobName()), String.format("§7Der Job verdient %x pro Aufgabe", jobEnum.getCoinsForATask())));
        jobItemItemMeta.getPersistentDataContainer().set(JobSystem.getJobSystem().getKey(), PersistentDataType.STRING, jobEnum.toString());
        jobItem.setItemMeta(jobItemItemMeta);
        return jobItem;
    }

    public void openInventory(Player player) {
        player.openInventory(inventory);
    }


}
