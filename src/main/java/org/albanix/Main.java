package org.albanix;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.albanix.api.interaction.Dispatcher;
import org.albanix.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ConfigManager configManager = new ConfigManager();

        try {
            configManager.init();
        } catch(Exception e) {
            log.error(e.getMessage());
        }

        Dispatcher dispatcher = new Dispatcher("org.albanix.core.commands");
        JDA jda = JDABuilder.createDefault(configManager.getToken())
                .addEventListeners(dispatcher)
                .build();
        jda.updateCommands().addCommands(dispatcher.getCommandData()).queue();
    }
}