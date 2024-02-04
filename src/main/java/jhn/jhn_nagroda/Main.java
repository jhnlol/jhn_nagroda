package jhn.jhn_nagroda;

import jhn.jhn_nagroda.Bot.Bot;
import jhn.jhn_nagroda.Configs.ConfigurationFile;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {
    private Bot bot;
    public static ConfigurationFile file;
    @Override
    public void onEnable() {

        file = new ConfigurationFile(new File(getDataFolder(), "config.yml"));
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
                ConfigurationFile ConfigFile = new ConfigurationFile(configFile);
                ConfigFile.getOdebraniData().set("config.token", "discord_token");
                try {
                    ConfigFile.getOdebraniData().save(configFile);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ConfigurationFile ConfigFile = new ConfigurationFile(configFile);
        bot = new Bot();
        bot.startBot(ConfigFile.getOdebraniData().getString("config.token"));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
