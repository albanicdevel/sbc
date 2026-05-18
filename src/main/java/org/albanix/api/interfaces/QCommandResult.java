package org.albanix.api.interfaces;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public interface QCommandResult {
    /**
     * Спосіб наданні запиту до діскорд
     * @param event подія команди на яку треба відповісти
     */
    void send(SlashCommandInteractionEvent event);
}
