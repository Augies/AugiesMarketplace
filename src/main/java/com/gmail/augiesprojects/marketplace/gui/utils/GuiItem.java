package com.gmail.augiesprojects.marketplace.gui.utils;

import org.bukkit.inventory.ItemStack;

public enum GuiItem {
    ERROR_ITEM("\u00A7c\u00A7lError"),
    NEXT_PAGE("\u00A7a\u00A7lNext Page"),
    PREVIOUS_PAGE("\u00A7a\u00A7lPrevious Page");


    private ItemStack itemStack;
    private String name;

    GuiItem(String name){
        this.itemStack = GuiItemFactory.getGuiItem(this.name());
        this.name = name;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public String getDisplayName(){
        return name;
    }
}