package org.albanix.events.slash;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.albanix.commands.CommandContext;
import org.albanix.commands.base.Ping;
import org.albanix.config.ConfigManager;
import org.albanix.events.ICommand;

import java.util.Map;

public class CommandDispatcher extends ListenerAdapter {
    private final Map<String, ICommand> commands;
    private final ConfigManager config;

    public CommandDispatcher(Map<String, ICommand> commands, ConfigManager config) {
        this.commands = commands;
        this.config = config;
    }

    public void init() {
        commands.put("ping", new Ping());
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String commandName = event.getName();
        ICommand command = commands.get(commandName);
        CommandContext context = new CommandContext(event, config);
        if(command != null) {
            command.execute(context);
        }
    }
}
