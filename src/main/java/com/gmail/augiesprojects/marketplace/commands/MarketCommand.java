package com.gmail.augiesprojects.marketplace.commands;

import com.gmail.augiesprojects.marketplace.Main;
import com.gmail.augiesprojects.marketplace.gui.panels.HomeGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MarketCommand implements CommandExecutor {
    HomeGui homeGui;
    Main main;

    public MarketCommand(Main main){
        this.main = main;
        homeGui = new HomeGui(main);
    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            homeGui.openInventory((Player) commandSender);
        }
        return true;
    }
}
