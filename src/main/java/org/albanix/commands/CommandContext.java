package org.albanix.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.albanix.config.ConfigManager;
import org.jetbrains.annotations.NotNull;

public class CommandContext {
    private final SlashCommandInteractionEvent event;
    private final ConfigManager configManager;

    public CommandContext(@NotNull SlashCommandInteractionEvent event, @NotNull ConfigManager configManager) {
        this.event = event;
        this.configManager = configManager;
    }

    public SlashCommandInteractionEvent getEvent() {
        return event;
    }

    public ConfigManager getConfig() {
        return configManager;
    }

    // ну можна зробити декілька методів з відісиланням ембедів або компонентів
    public void reply(String message) {
        event.reply(message).queue();
    }
}
