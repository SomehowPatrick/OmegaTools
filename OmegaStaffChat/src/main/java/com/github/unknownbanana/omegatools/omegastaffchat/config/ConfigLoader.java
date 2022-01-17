package com.github.unknownbanana.omegatools.omegastaffchat.config;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.config.Configuration;

/**
 * Loads data from a {@link Configuration}
 *
 * @author UnknownBanana
 * @version 1.0
 * @see Configuration
 * @since 1.0
 */

public class ConfigLoader {
    protected final Configuration configuration;

    private final String use_permission;
    private final String see_permission;
    private final String chat_format;
    private final String no_permission;
    private final String wrong_arguments;

    /**
     * Loads the data from the configuration
     *
     * @param configuration The configuration to load from
     */
    public ConfigLoader(Configuration configuration) {
        this.configuration = configuration;
        this.use_permission = this.configuration.getString("permissions.use_permission");
        this.see_permission = this.configuration.getString("permissions.see_permission");
        this.chat_format = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("chat.format"));
        this.no_permission = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("chat.no_permission"));
        this.wrong_arguments = ChatColor.translateAlternateColorCodes('&', this.configuration.getString("chat.wrong_arguments"));
    }

    public String getUse_permission() {
        return this.use_permission;
    }

    public String getSee_permission() {
        return this.see_permission;
    }

    public String getChat_format() {
        return this.chat_format;
    }

    public String getNo_permission() {
        return this.no_permission;
    }

    public String getWrong_arguments() {
        return this.wrong_arguments;
    }
}
