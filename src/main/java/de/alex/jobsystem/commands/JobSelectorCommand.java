package de.alex.jobsystem.commands;

import de.alex.jobsystem.main.JobSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JobSelectorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            JobSystem.getJobSystem().getJobSelectorInventory().openInventory(player);
        }
        return false;
    }
}
