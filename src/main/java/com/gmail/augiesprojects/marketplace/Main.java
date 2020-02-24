package com.gmail.augiesprojects.marketplace;

import com.gmail.augiesprojects.marketplace.commands.MarketCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private MarketCommand marketCommand;

    public void onEnable(){
        marketCommand = new MarketCommand(this);
        this.getServer().getPluginCommand("amarket").setExecutor(marketCommand);
    }

    public void onDisable(){
        marketCommand = null;
    }
}
