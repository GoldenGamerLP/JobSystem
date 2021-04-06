package de.alex.jobsystem.main;

import de.alex.jobsystem.commands.JobSelectorCommand;
import de.alex.jobsystem.commands.JobTreatCommand;
import de.alex.jobsystem.inventorys.JobSelectorInventory;
import de.alex.jobsystem.inventorys.JobTreatInventory;
import de.alex.jobsystem.jobplayer.JobPlayerManager;
import de.alex.jobsystem.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class JobSystem extends JavaPlugin {

    private static JobSystem jobSystem;
    private final NamespacedKey key = new NamespacedKey(this, "job");
    private JobPlayerManager jobPlayerManager;
    private JobSelectorInventory jobSelectorInventory;
    private JobTreatInventory jobTreatInventory;

    public static JobSystem getJobSystem() {
        return jobSystem;
    }

    @Override
    public void onEnable() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        //Startup
        jobSystem = this;
        this.jobPlayerManager = new JobPlayerManager();
        this.jobSelectorInventory = new JobSelectorInventory();
        this.jobTreatInventory = new JobTreatInventory();

        jobSelectorInventory.initInventory();

        getCommand("jobs").setExecutor(new JobSelectorCommand());
        getCommand("lohn").setExecutor(new JobTreatCommand());

        pluginManager.registerEvents(new PlayerBlockBreakEvent(), this);
        pluginManager.registerEvents(new PlayerFishingEvent(), this);
        pluginManager.registerEvents(new PlayerInventoryInteractEvent(), this);
        pluginManager.registerEvents(new PlayerQuitEvent(), this);
        pluginManager.registerEvents(new PlayerJoinEvent(), this);
    }

    public JobPlayerManager getJobPlayerManager() {
        return jobPlayerManager;
    }

    public JobSelectorInventory getJobSelectorInventory() {
        return jobSelectorInventory;
    }

    public JobTreatInventory getJobTreatInventory() {
        return jobTreatInventory;
    }

    public NamespacedKey getKey() {
        return key;
    }
}
