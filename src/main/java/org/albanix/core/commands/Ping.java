package org.albanix.core.commands;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.albanix.api.client.channel.TextResult;
import org.albanix.api.interfaces.QCommand;
import org.albanix.api.interfaces.QCommandContext;
import org.albanix.api.interfaces.QCommandResult;

public class Ping implements QCommand {
    @Override
    public CommandData getData() {
        return Commands.slash("ping", "ping-pong");
    }

    @Override
    public QCommandResult execute(QCommandContext ctx) {
        return new TextResult("pong!", true);
    }
}
