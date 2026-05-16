package org.albanix.api.interaction;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import org.albanix.api.interfaces.QCommandContext;

import java.util.Optional;

public class CommandContext implements QCommandContext {
    private final SlashCommandInteraction event;
    public CommandContext(SlashCommandInteractionEvent event) {
        this.event = event;
    }

    @Override
    public SlashCommandInteraction getInter() {
        return event;
    }

    @Override
    public Member getMember() {
        return event.getMember();
    }

    @Override
    public MessageChannelUnion getChannel() {
        return event.getChannel();
    }

    @Override
    public Optional<Guild> getGuild() {
        return Optional.ofNullable(event.getGuild());
    }
}
