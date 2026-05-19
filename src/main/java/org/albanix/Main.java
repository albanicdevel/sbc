package org.albanix;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.albanix.api.client.Client;
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

        Client client = new Client(configManager.getToken());
        client.changeStatus("Status");
    }
}