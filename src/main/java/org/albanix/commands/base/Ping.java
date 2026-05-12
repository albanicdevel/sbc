package org.albanix.commands.base;

import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.albanix.commands.CommandContext;
import org.albanix.events.ICommand;

public class Ping implements ICommand {
    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public CommandData getCommandData() {
        return Commands.slash(getName(), "test");
    }

    @Override
    public void execute(CommandContext ctx) {
        ctx.reply("hi!");
    }
}
