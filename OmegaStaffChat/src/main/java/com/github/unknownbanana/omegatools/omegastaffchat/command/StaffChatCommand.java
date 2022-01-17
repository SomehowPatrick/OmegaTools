package com.github.unknownbanana.omegatools.omegastaffchat.command;

import com.github.unknownbanana.omegatools.omegastaffchat.OmegaStaffChat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import javax.swing.*;

/**
 * Main command of the plugin
 *
 * @author UnknownBanana
 * @version 1.0
 * @see Command
 * @since 1.0
 */

public class StaffChatCommand extends Command {
    protected final OmegaStaffChat omegaStaffChat;

    /**
     * Creates a new command
     *
     * @param name           The name of the command
     * @param omegaStaffChat An instance of the {@link net.md_5.bungee.api.plugin.Plugin} class
     */

    public StaffChatCommand(String name, OmegaStaffChat omegaStaffChat) {
        super(name);
        this.omegaStaffChat = omegaStaffChat;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof ProxiedPlayer player) {
            if (!player.hasPermission(this.omegaStaffChat.getConfigLoader().getUse_permission())) {
                player.sendMessage(this.omegaStaffChat.getConfigLoader().getNo_permission());
                return;
            }
            if (args.length == 0) {
                player.sendMessage(this.omegaStaffChat.getConfigLoader().getWrong_arguments());
                return;
            }
            sendToAll(player.getName(), args);
        } else {
            if (args.length == 0) {
                sender.sendMessage(this.omegaStaffChat.getConfigLoader().getWrong_arguments());
                return;
            }
            sendToAll("Console", args);
        }
    }

    /**
     * Sends a message to all users connected to a bungeecord proxy
     *
     * @param name The name of the command
     * @param args The arguments passed by the command
     */

    private void sendToAll(String name, String[] args) {
        this.omegaStaffChat.getProxy().getPlayers().forEach(player -> {
            if (player.hasPermission(this.omegaStaffChat.getConfigLoader().getSee_permission())) {
                player.sendMessage(
                        this.omegaStaffChat.getConfigLoader().getChat_format()
                                .replace("%player%", name)
                                .replace("%message%", ChatColor.translateAlternateColorCodes('&', buildMessage(args)))
                );
            }
        });
    }

    /**
     * Builds a message based of command arguments
     *
     * @param args The arguments
     * @return A string built out of the arguments
     */

    private String buildMessage(String[] args) {
        StringBuilder message = new StringBuilder();

        for (var arg : args) {
            if (message.toString().equals("")) {
                message = new StringBuilder(arg);
            } else {
                message.append(" ").append(arg);
            }
        }
        return message.toString();
    }
}
