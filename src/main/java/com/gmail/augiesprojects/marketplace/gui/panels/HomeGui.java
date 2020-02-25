package com.gmail.augiesprojects.marketplace.gui.panels;

import com.gmail.augiesprojects.marketplace.gui.MarketplaceGui;
import com.gmail.augiesprojects.marketplace.gui.utils.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class HomeGui extends MarketplaceGui {
    public HomeGui(Plugin plugin) {
        super(54, "Home Page", plugin);
    }

    @Override
    @EventHandler(priority = EventPriority.NORMAL)
    public void onInventoryClick(InventoryClickEvent event){
        if(isGuiInventory(event)){
            //TODO
            event.getWhoClicked().sendMessage("Hello");
            event.setCancelled(true);
        }
    }

    @Override
    public void initializeInv() {
        inventory.setItem(48, GuiItem.PREVIOUS_PAGE.getItemStack());
        inventory.setItem(50, GuiItem.NEXT_PAGE.getItemStack());
    }
}
