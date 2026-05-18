package org.albanix.api.interaction;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.albanix.api.interfaces.QCommand;
import org.albanix.core.modules.CoreModules;
import org.albanix.core.repository.CommandExecutor;
import org.albanix.core.repository.CommandRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dispatcher extends ListenerAdapter {
    private static final Logger log = LoggerFactory.getLogger(Dispatcher.class);
    private final CommandRegistry registry = new CommandRegistry();
    private final CommandExecutor executor = new CommandExecutor();

    public Dispatcher() {
        registry.registerModule(new CoreModules());
    }

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        QCommand command = registry.getCommands(event.getName());
        if(command == null) {
            log.info("Команду [/{}] не мож використати", event.getName());
            return;
        }
        executor.execute(event, command);
    }

    public CommandRegistry getRegistry() {
        return registry;
    }
}
