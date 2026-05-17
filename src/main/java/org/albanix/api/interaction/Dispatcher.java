package org.albanix.api.interaction;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.albanix.api.client.channel.TextResult;
import org.albanix.api.commands.CommandModule;
import org.albanix.api.interfaces.QCommand;
import org.albanix.api.interfaces.QCommandContext;
import org.albanix.api.interfaces.QCommandResult;
import org.albanix.core.modules.CoreModules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dispatcher extends ListenerAdapter {
    private static final Logger log = LoggerFactory.getLogger(Dispatcher.class);
    private final Map<String, QCommand> commandsMap = new HashMap<>();

    public Dispatcher() {
        CoreModules coreModules = new CoreModules();
        coreModules.configure();
        registerModule(coreModules);
    }

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
        QCommandResult result = command.execute(context);

        switch (result) {
            case TextResult textResult -> {
                event.reply(textResult.getContent())
                        .setEphemeral(textResult.isEphemeral())
                        .queue();
            }
            default -> event.deferReply().queue();
        }
    }

    private void register(QCommand command) {
        commandsMap.put(command.getData().getName(), command);
    }

    private void registerModule(CommandModule module) {
        for(QCommand command : module.getModuleCommand()) {
            register(command);
            log.info("Команда [/{}] зареєстрована!", command.getData().getName());
        }
    }

    public List<CommandData> getCommandData() {
        return commandsMap.values().stream()
                .map(QCommand::getData)
                .toList();
    }
}
