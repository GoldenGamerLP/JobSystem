package de.alex.jobsystem.inventorys;

import de.alex.jobsystem.jobplayer.JobEnum;
import de.alex.jobsystem.jobplayer.JobPlayer;
import de.alex.jobsystem.main.JobSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DateFormat;
import java.util.Arrays;

public class JobTreatInventory {

    public void openInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, InventoryType.CHEST, "§bJob Coins Abholen!");
        JobPlayer jobPlayer = JobSystem.getJobSystem().getJobPlayerManager().addGetOrGet(player);
        String lastRecieved = jobPlayer.getLastPickUp() == 0 ? "---" : "" + (DateFormat.getInstance().format(System.currentTimeMillis() - jobPlayer.getLastPickUp()));

        if (jobPlayer.getCurrentJobCoins() != 0) {
            ItemStack treatItemStack = new ItemStack(Material.GLOWSTONE_DUST, 1);
            ItemMeta treatItemMeta = treatItemStack.getItemMeta();
            assert treatItemMeta != null;
            treatItemMeta.setDisplayName(String.format("%x §6Coins abholen!", jobPlayer.getCurrentJobCoins()));
            treatItemMeta.setLore(Arrays.asList("§7", String.format("§6Zu letzt abgeholt vor: %s", lastRecieved)));
            treatItemStack.setItemMeta(treatItemMeta);
            inventory.setItem(14, treatItemStack);
        } else if (jobPlayer.getJobEnum().equals(JobEnum.NOJOB)) {
            ItemStack noJobItem = new ItemStack(Material.GUNPOWDER, 1);
            ItemMeta noJobItemItemMeta = noJobItem.getItemMeta();
            assert noJobItemItemMeta != null;
            noJobItemItemMeta.setDisplayName("§cDu hast keinen Job um Coins zu bekommen!");
            noJobItemItemMeta.setLore(Arrays.asList("§7", String.format("§6Zu letzt abgeholt vor: %s", lastRecieved)));
            noJobItem.setItemMeta(noJobItemItemMeta);
            inventory.setItem(14, noJobItem);
        } else {
            ItemStack noCoinsItemStack = new ItemStack(Material.GUNPOWDER, 1);
            ItemMeta noCoinsItemStackItemMeta = noCoinsItemStack.getItemMeta();
            assert noCoinsItemStackItemMeta != null;
            noCoinsItemStackItemMeta.setDisplayName("§cKeine Coins erarbeitet!!");
            noCoinsItemStackItemMeta.setLore(Arrays.asList("§7", String.format("§6Zu letzt abgeholt vor: %s", lastRecieved)));
            noCoinsItemStack.setItemMeta(noCoinsItemStackItemMeta);
            inventory.setItem(14, noCoinsItemStack);
        }
    }

}
