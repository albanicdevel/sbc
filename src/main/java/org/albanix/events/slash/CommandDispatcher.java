package org.albanix.events.slash;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.albanix.commands.CommandContext;
import org.albanix.commands.base.Ping;
import org.albanix.commands.repo.CommandRegistry;
import org.albanix.config.ConfigManager;
import org.albanix.events.ICommand;

import java.util.Map;

public class CommandDispatcher extends ListenerAdapter {
    private final Map<String, ICommand> commands;
    private final ConfigManager config;
    CommandRegistry registry;

    public CommandDispatcher(Map<String, ICommand> commands, ConfigManager config) {
        this.commands = commands;
        this.config = config;
    }

    public void init(JDA jda) {
        this.registry =  new CommandRegistry(commands);

        registry.register(new Ping());
        registry.append(jda);
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        ICommand command = registry.getCommand(event.getName());
        if(command != null) {
            CommandContext context = new CommandContext(event, config);
            command.execute(context);
        }
    }
}
