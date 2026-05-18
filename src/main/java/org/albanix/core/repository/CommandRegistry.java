package org.albanix.core.repository;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.albanix.api.commands.CommandModule;
import org.albanix.api.interfaces.QCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandRegistry {
    private static final Logger log = LoggerFactory.getLogger(CommandRegistry.class);
    private final Map<String, QCommand> commandsMap = new HashMap<>();

    public void registerModule(CommandModule module) {
        module.configure();

        for(QCommand command : module.getModuleCommand()) {
            String name = command.getData().getName();
            commandsMap.put(name, command);
            log.info("Команда [/{}] успішно зареєстрована з модулю {}", name, module.getName());
        }
    }

    public QCommand getCommands(String name) {
        return commandsMap.get(name);
    }

    public List<CommandData> getData() {
        return commandsMap.values().stream()
                .map(QCommand::getData)
                .toList();
    }
}
