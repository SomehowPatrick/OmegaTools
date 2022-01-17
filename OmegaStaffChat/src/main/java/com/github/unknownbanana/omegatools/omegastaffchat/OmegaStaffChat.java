package com.github.unknownbanana.omegatools.omegastaffchat;

import com.github.unknownbanana.omegatools.omegastaffchat.command.StaffChatCommand;
import com.github.unknownbanana.omegatools.omegastaffchat.config.ConfigLoader;
import com.github.unknownbanana.omegatools.omegastaffchat.util.FileUtil;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Main entrypoint of the plugin
 *
 * @author UnknownBanana
 * @version 1.0
 * @see Plugin
 * @since 1.0
 */

public class OmegaStaffChat extends Plugin {
    private ConfigLoader configLoader;

    @Override
    public void onEnable() {
        FileUtil.saveDefaultConfig(this);
        loadConfig();
        getLogger().info("OmegaStaffChat enabled!");

        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand("staffchat", this));
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand("sc", this));
    }

    @Override
    public void onDisable() {
        getLogger().info("OmegaStaffChat disabled!");
    }

    /**
     * Loads the config
     */

    private void loadConfig() {
        try {
            configLoader = new ConfigLoader(YamlConfiguration.getProvider(YamlConfiguration.class).load(new File(getDataFolder(), "config.yml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ConfigLoader getConfigLoader() {
        return this.configLoader;
    }
}
