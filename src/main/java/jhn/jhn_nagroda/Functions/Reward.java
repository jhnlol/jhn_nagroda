package jhn.jhn_nagroda.Functions;

import jhn.jhn_nagroda.Configs.ConfigurationFile;
import jhn.jhn_nagroda.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class Reward {

    public String add(String nick) {
        File dataFile2 = new File(Main.getPlugin(Main.class).getDataFolder(), "config.yml");
        ConfigurationFile dataFile = new ConfigurationFile(dataFile2);
        Player player = Bukkit.getPlayer(nick);
        if (player == null) {
            return "Nie ma takiego gracza na serwerze!";
        }
        if ("get".equals(dataFile.getOdebraniData().getString("config.data." + player.getUniqueId()))) {
            return "Odebrałeś już nagrodę";
        }

        dataFile.getOdebraniData().set("data." + player.getUniqueId(), "get");
        try {
            dataFile.getOdebraniData().save(dataFile.getOdebraniFile());
        } catch (IOException e) {
            e.printStackTrace();
            return "Wystąpił błąd podczas zapisywania nagrody";
        }

        player.getInventory().addItem(new ItemStack(Material.BREAD, 2));
        return "Nadano nagrodę!";
    }
}