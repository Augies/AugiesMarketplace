package com.gmail.augiesprojects.marketplace.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;

public abstract class MarketplaceGui implements InventoryHolder, Listener {
    private final Plugin plugin;
    protected final Inventory inventory;

    public MarketplaceGui(int size, String name, Plugin plugin) {
        this.inventory = Bukkit.createInventory(this, size, name);
        initializeInv();
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void openInventory(Player p){
        p.openInventory(inventory);
    }

    public abstract void onInventoryClick(InventoryClickEvent event);

    public abstract void initializeInv();

    public static boolean isValidOnClickEvent(InventoryClickEvent event){
        return event.getClick() == ClickType.LEFT;
    }

    public boolean isGuiInventory(InventoryClickEvent event){
        boolean isGuiInventory = false;
        if(event.getClickedInventory()==inventory || (event.getView().getTopInventory()==inventory && (event.getClick()==ClickType.SHIFT_LEFT || event.getClick()==ClickType.SHIFT_RIGHT))){
            isGuiInventory = true;
        }
        return isGuiInventory;
    }
}
