package org.albanix.api.interfaces;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;

import java.util.Optional;

public interface QCommandContext {
    // я вирішив реалізувати біль декларативний інтерфейс
    SlashCommandInteraction getInter();
    Member getMember();
    MessageChannelUnion getChannel();
    Optional<Guild> getGuild();
}

/*
    Контекст для зручної взаємодії між вами та discord - api
 */