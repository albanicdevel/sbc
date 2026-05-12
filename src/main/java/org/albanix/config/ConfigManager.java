package org.albanix.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigManager {
    private static final Logger log = LoggerFactory.getLogger(ConfigManager.class);
    private ConfigurationNode rootNode;

    public void init() throws Exception {
        Path path = Paths.get("config.yml");
        if(Files.notExists(path)) {
            log.info("Trying get resources...");
            try(InputStream in = getClass().getClassLoader().getResourceAsStream("config.yml")) {
                if(in != null) {
                    Files.copy(in, path);
                    log.info("Success");
                }
            }
        }

        YamlConfigurationLoader loader = YamlConfigurationLoader.builder()
                .path(path)
                .build();

        rootNode = loader.load();
    }

    public ConfigurationNode getRoot() {
        return rootNode;
    }

    public String getToken() {
        return rootNode.node("client", "token").getString(); // <--- тут може бути фолбек токену
    }
}