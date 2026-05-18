package org.albanix.core.repository;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.albanix.api.interaction.CommandContext;
import org.albanix.api.interfaces.QCommand;
import org.albanix.api.interfaces.QCommandContext;
import org.albanix.api.interfaces.QCommandResult;

import java.util.Set;

public class CommandExecutor {
    public void execute(SlashCommandInteractionEvent event, QCommand command) {
        Set<Permission> permissions = command.getRequiredPermissions();
        if(event.getMember() != null && !event.getMember().hasPermission(permissions)) {
            event.reply("та це капець! У вас прав нема!").setEphemeral(true).queue();
            return;
        }

        QCommandContext context = new CommandContext(event);
        QCommandResult result = command.execute(context);

        if(result != null) {
            result.send(event);
        } else {
            event.deferReply().queue();
        }
    }
}
