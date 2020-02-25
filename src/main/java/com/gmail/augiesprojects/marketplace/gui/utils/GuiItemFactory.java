package com.gmail.augiesprojects.marketplace.gui.utils;

import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class GuiItemFactory{
    private static ItemFactory itemFactory = Bukkit.getItemFactory();

    public static ItemStack getGuiItem(String itemName) {
        if(itemName == null){
            return null;
        }
        switch(itemName){
            case "NEXT_PAGE":
                return getNextPage();
            case "ERROR_ITEM":
                return getErrorItem();
            case "PREVIOUS_PAGE":
                return getPreviousPage();
            default:
                return getDefaultItem();
        }
    }

    @NotNull
    private static ItemStack getDefaultItem(){
        return new ItemStack(Material.AIR, 1);
    }

    /**
     * Create a banner with an arrow pointing right
     * @return a right arrow
     */
    @NotNull
    private static ItemStack getNextPage(){
        return getRootPageBanner(PatternType.STRIPE_RIGHT);
    }

    /**
     * Create a banner with an arrow pointing left
     * @return a left arrow
     */
    @NotNull
    private static ItemStack getPreviousPage(){
        return getRootPageBanner(PatternType.STRIPE_LEFT);
    }

    @NotNull
    private static ItemStack getRootPageBanner(PatternType stripeLeft) {
        ItemStack previousPage = new ItemStack(Material.BLACK_BANNER, 1);
        BannerMeta bMeta = (BannerMeta)previousPage.getItemMeta();

        DyeColor[] colors = {DyeColor.WHITE,DyeColor.WHITE,DyeColor.BLACK,DyeColor.BLACK,DyeColor.BLACK,DyeColor.BLACK,DyeColor.BLACK,DyeColor.BLACK};
        PatternType[] patterns = {stripeLeft, PatternType.STRIPE_MIDDLE, PatternType.STRIPE_TOP, PatternType.STRIPE_BOTTOM, PatternType.CURLY_BORDER,  PatternType.CURLY_BORDER, PatternType.STRIPE_TOP, PatternType.STRIPE_BOTTOM};
        for(int i = 0; i < 8; i++){
            bMeta.addPattern(new Pattern(colors[i], patterns[i]));
        }

        bMeta.setDisplayName("\u00A7a\u00A7lNext Page");
        previousPage.setItemMeta(bMeta);
        return previousPage;
    }

    @NotNull
    private static ItemStack getErrorItem(){
        ItemStack error = new ItemStack(Material.BARRIER, 1);
        ItemMeta meta = error.getItemMeta();
        meta.setDisplayName("\u00A7c\u00A7lERROR");
        error.setItemMeta(meta);
        return error;
    }
}
