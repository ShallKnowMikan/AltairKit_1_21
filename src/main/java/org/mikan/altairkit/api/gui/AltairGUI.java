package org.mikan.altairkit.api.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.mikan.altairkit.AltairKit;

public abstract class AltairGUI {

    protected ItemStack fillerItem;
    protected String title;
    protected int slots;
    protected Inventory gui;
    protected int page;

    public AltairGUI(ItemStack fillerItem, String title, int slots,boolean fill) {

        this.fillerItem = fillerItem;
        this.title = AltairKit.colorize(title);
        this.slots = slots;

        if (fill) createSurroundedPage();
        else createGUI();
    }



    public AltairGUI(ItemStack fillerItem, String title, int slots) {
        this.fillerItem = fillerItem;
        this.title = AltairKit.colorize(title);
        this.slots = slots;

        createSurroundedPage();
    }

    public AltairGUI(ItemStack fillerItem, String title, int slots,int page) {
        this.fillerItem = fillerItem;
        this.title = AltairKit.colorize(title);
        this.slots = slots;
        this.page = page;

        createSurroundedPage();
    }




    public AltairGUI(String title, int slots) {
        this.title = AltairKit.colorize(title);
        this.slots = slots;

        createGUI();
    }

    public AltairGUI(String title, int slots,int page) {
        this.title = AltairKit.colorize(title);
        this.slots = slots;
        this.page = page;

        createGUI();
    }


    public AltairGUI(Inventory inventory,int page){
        this.slots = inventory.getSize();
        this.title = "UNKNOWN";
        this.page = page;

        this.gui = inventory;
    }


    protected void rebuild(String title,boolean fill){
        this.title = AltairKit.colorize(title);
        if (fill) createSurroundedPage();
        else createGUI();
    }


    public void show(Player player){
        player.openInventory(this.gui);
        Data.addToMap(player,title);
    }




    private void createGUI(){
        this.gui = Bukkit.createInventory(null, slots, title);
    }



    protected void createSurroundedPage() {

        this.gui = Bukkit.createInventory(null, slots, title);

        if (this.fillerItem == null) return;

        switch (slots){
            case 54:
                load54SlotsGUI();
                break;
            case 45:
                load45SlotsGUI();
                break;
            case 36:
                load36SlotsGUI();
                break;
            case 27:
                load27SlotsGUI();
                break;
            case 18:
                load18SlotsGUI();
                break;
            case 9:
                load9SlotsGUI();
                break;
        }

    }




    private void load9SlotsGUI(){
        for(int i = 0; i < this.slots; ++i)
            if (i == 4)
                this.gui.setItem(i, this.fillerItem);
    }





    private void load18SlotsGUI(){
        for(int i = 0; i < this.slots; ++i)
            if (i == 0 || i == 8 || i == 9 || i == 17)
                this.gui.setItem(i, this.fillerItem);
    }




    private void load27SlotsGUI(){
        for(int i = 0; i < this.slots; ++i)
            if (i <= 9 || i >= 17)
                this.gui.setItem(i, this.fillerItem);
    }




    private void load36SlotsGUI(){
        for(int i = 0; i < this.slots; ++i)
            if (i <= 9 || i == 18 || i >= 26 || i == 17)
                this.gui.setItem(i, this.fillerItem);
    }



    private void load45SlotsGUI(){
        for(int i = 0; i < this.slots; ++i)
            if (i <= 9 || i == 18 || i == 27 || i == 26 || i == 17 || i >= 35)
                this.gui.setItem(i, this.fillerItem);
    }




    private void load54SlotsGUI(){
        for(int i = 0; i < this.slots; ++i)
            if (i <= 9 || i == 18 || i == 27 || i == 26 || i == 17 || i == 36 || i == 35 || i >= 44)
                this.gui.setItem(i, this.fillerItem);
    }

}
