package org.albanix.api.interaction;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.albanix.api.interfaces.QCommand;
import org.albanix.api.interfaces.QCommandContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Dispatcher implements ListenerAdapter {
    private final Map<String, QCommand> commandsMap = new HashMap<>();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String name = event.getName();
        QCommand command = commandsMap.get(name);
        if(command == null) {
            event.reply("Команди не існує! Щось пішло не так!").setEphemeral(true).queue();
            return;
        }

        Set<Permission> permissions = command.getRequiredPermissions();
        if(!event.getMember().hasPermission(permissions)) {
            event.reply("О такої у вас немає прав!").setEphemeral(true).queue();
            return;
        }

        QCommandContext context = new CommandContext(event);
        command.execute(context);
    }

    private void register(QCommand command) {
        commandsMap.put(command.getData().getName(), command);
    }
}
