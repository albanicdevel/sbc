package org.albanix;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.albanix.config.ConfigManager;
import org.albanix.events.ICommand;
import org.albanix.events.slash.CommandDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager();

        try {
            configManager.init();
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        Map<String, ICommand> commands = new HashMap<>();
        CommandDispatcher commandDispatcher = new CommandDispatcher(commands, configManager);
        JDA jda = JDABuilder.createDefault(configManager.getToken())
                .addEventListeners(commandDispatcher)
                .build();

        commandDispatcher.init(jda);
    }
}