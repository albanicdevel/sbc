package org.albanix.api.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import org.jetbrains.annotations.NotNull;

public class CommandContext {
    private final SlashCommandInteractionEvent event;

    public CommandContext(@NotNull SlashCommandInteractionEvent event) {
        this.event = event;
    }

    public void send(String text) {
        this.event.getChannel().sendMessage(text).queue();
    }
}
