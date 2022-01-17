package com.github.unknownbanana.omegatools.omegastaffchat.util;

import net.md_5.bungee.api.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Provides a utility method for saving a default config
 *
 * @author UnknownBanana
 * @version 1.0
 * @since 1.0
 */

public class FileUtil {

    /**
     * Saves a default config config.yml to the plugins folder
     *
     * @param plugin An instance of the plugin to save the config for
     */

    public static void saveDefaultConfig(Plugin plugin) {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        var file = new File(plugin.getDataFolder(), "config.yml");
        if (file.exists()) {
            return;
        }

        try (var stream = plugin.getResourceAsStream("config.yml")) {
            Files.copy(stream, file.toPath());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
