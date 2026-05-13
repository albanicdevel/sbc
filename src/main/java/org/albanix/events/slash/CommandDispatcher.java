package org.albanix.events.slash;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.albanix.commands.CommandContext;
import org.albanix.commands.base.Clear;
import org.albanix.commands.base.Ping;
import org.albanix.commands.repo.CommandRegistry;
import org.albanix.config.ConfigManager;
import org.albanix.events.ICommand;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher extends ListenerAdapter {
    private final ConfigManager config;
    CommandRegistry registry;

    public CommandDispatcher(ConfigManager config) {
        this.config = config;
    }

    public void init(JDA jda) {
        this.registry = new CommandRegistry(new HashMap<>());

        registry.register(new Ping());
        registry.register(new Clear());
        registry.append(jda);
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        ICommand command = registry.getCommand(event.getName());
        Permission[] perRequired = registry.getPermission(event.getName());
        if(command != null && perRequired != null) {
            for(Permission p : perRequired) {
                if(!event.getMember().hasPermission(p)) {
                    event.reply("Не достатньо прав!").queue();
                    return;
                }
            }
            CommandContext context = new CommandContext(event, config);
            command.execute(context);
        }
    }
}
