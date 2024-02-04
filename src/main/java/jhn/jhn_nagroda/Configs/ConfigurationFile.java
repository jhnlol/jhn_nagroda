package jhn.jhn_nagroda.Configs;

import jhn.jhn_nagroda.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigurationFile {
    private File odebraniFile;
    private FileConfiguration odebraniData;

    public ConfigurationFile(File file) {
        this.odebraniFile = file;
        this.odebraniData = YamlConfiguration.loadConfiguration(file);
    }
    public void setOdebraniFile(File odebraniFile) {
        this.odebraniFile = odebraniFile;
    }

    public  File getOdebraniFile() {
        return odebraniFile;
    }
    public FileConfiguration getOdebraniData() {
        return odebraniData;
    }
}
